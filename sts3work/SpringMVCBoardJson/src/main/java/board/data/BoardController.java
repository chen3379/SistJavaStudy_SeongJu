package board.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.answer.data.AnswerDao;
import board.answer.data.AnswerDto;

@Controller
public class BoardController {

	@Autowired
	BoardDao dao;
	@Autowired
	AnswerDao adao;

	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {

		ModelAndView mav = new ModelAndView();
		int totalCount = dao.getTotalCount();// 전체 글개수
		int perPage = 5; // 한페이지에 보여질 글갯수
		int perBlock = 5; // 한블럭에 보여질 페이지갯수
		int startNum = 0; // db에서 가져올 글의 시작번호(mysql이므로 첫글이 0,오라클은 1)
		int startPage; // 각블럭당 보여질 시작페이지
		int endPage; //// 각블럭당 보여질 끝페이지
		int totalPage; // 총페이지

		int no; // 각페이지당 출력할 시작번호

		// 총페이지구하기
		// 총페이지갯수/한페이지에 보여질 갯수로 나눔(7/5=1)
		// 나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 필요)
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

		// 각블럭당 보여질 시작페이지
		// perBlock=5일경우 현재페이지 1~5일경우는 시작페이지1,끝5
		// 만약 현재페이지가 13 시작:11 끝:15
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;

		// 총페이지갯수가 23일경우 마지막 25가 아니라 23
		if (endPage > totalPage)
			endPage = totalPage;

		// 각페이지에서 보여질 시작번호(5개의 글을 한페이지)
		// 예: 1페이지->0 2페이지: 5 3페이지:10..
		startNum = (currentPage - 1) * perPage;

		no = totalCount - (currentPage - 1) * perPage;

		List<BoardDto> list = dao.selectBoard(startNum, perPage);
		
		for(BoardDto d:list) {
			d.setAcount(adao.selectAll(d.getNum()).size());
		}
			
			
		mav.addObject("list", list);
		mav.addObject("totalCount", totalCount);
		mav.addObject("totalPage", totalPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("currentPage", currentPage);
		mav.addObject("no", no);

		mav.setViewName("board/boardlist");

		return mav;
	}

	@GetMapping("/board/addform")
	public String addform() {
		return "board/writeform";
	}

	@PostMapping("/board/add")
	public String add(@ModelAttribute BoardDto dto, @RequestParam ArrayList<MultipartFile> upload,
			HttpSession session) {

		// 업로드실제경로
		String path = session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);

		String photo = "";

		if (upload.get(0).getOriginalFilename().equals("")) {
			photo = "no-image";
		} else {
			for (MultipartFile f : upload) {
				String fName = f.getOriginalFilename();
				photo += fName + ",";

				// 업로드
				try {
					f.transferTo(new File(path + "\\" + fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			photo = photo.substring(0, photo.length() - 1);
		}
		dto.setPhoto(photo);

		dao.insertBoard(dto);
		return "redirect:list";
	}

	@GetMapping("/board/content")
	public String content(@RequestParam int num, Model model, @RequestParam int currentPage) {
		BoardDto dto = dao.selectContent(num);
		dao.updateReadcount(num);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);

		//num에 해당하는 댓글을 db에서 가져와서 request에 저장
		List<AnswerDto> aList=adao.selectAll(num);
		
		//댓글이 있을 때만 보낸다
		model.addAttribute("aList",aList);
		model.addAttribute("acount",aList.size());
		
		return "board/content";
	}

	@GetMapping("/board/deletepassform")
	public ModelAndView deletePassForm(@RequestParam int num, @RequestParam int currentPage) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("num", num);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("board/deletepassform");

		return mav;
	}

	@PostMapping("/board/deletepass")
	public ModelAndView deleteBoard(@RequestParam int num, @RequestParam int pass, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int check = dao.getCheckPass(num, pass);

		if (check == 1) {
			// photo폴더 사진삭제
			String oldphoto = dao.selectContent(num).getPhoto();
			if (!oldphoto.equals("no-image")) {
				// ,로 분리해서 배열에 담기
				String[] fName = oldphoto.split(",");

				// 실제업로드
				String path = session.getServletContext().getRealPath("/WEB-INF/photo");

				for (String f : fName) {
					File file = new File(path + "\\" + f);
					file.delete();
				}
			}

			dao.deleteBoard(num);
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("board/passfail");
		}

		return mav;
	}

	@GetMapping("/board/updatepassform")
	public ModelAndView updatePassForm(@RequestParam int num, @RequestParam int currentPage) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("num", num);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("board/updatepassform");

		return mav;
	}

	@PostMapping("/board/updatepass")
	public ModelAndView updatepass(@RequestParam int num, @RequestParam int pass, @RequestParam int currentPage) {
		ModelAndView mav = new ModelAndView();

		// 비번 맞을 경우 수정폼으로 포워드,틀릴 경우 passfail
		int check = dao.getCheckPass(num, pass);

		if (check == 1) {
			// 맞으면 dto 얻어서 포워드
			BoardDto dto = dao.selectContent(num);

			mav.addObject("dto", dto);
			mav.addObject("currentPage", currentPage);
			mav.setViewName("board/updateform");
		} else {
			mav.setViewName("board/passfail");
		}

		return mav;
	}

	@PostMapping("/board/update")
	public String updateBoard(@ModelAttribute BoardDto dto,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam ArrayList<MultipartFile> upload, HttpSession session) {

		// 업로드실제경로
		String path = session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);

		String photo = "";

		if (upload.get(0).getOriginalFilename().equals("")) {
			photo = null;
		} else {
			for (MultipartFile f : upload) {
				String fName = f.getOriginalFilename();
				photo += fName + ",";

				// 업로드
				try {
					f.transferTo(new File(path + "\\" + fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			photo = photo.substring(0, photo.length() - 1);
		}
		dto.setPhoto(photo);

		dao.updateBoard(dto);

		return "redirect:content?num=" + dto.getNum() + "&currentPage=" + currentPage;
	}
}
