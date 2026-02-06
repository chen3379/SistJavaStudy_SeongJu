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

@Controller
public class BoardController {

	@Autowired
	BoardDao dao;

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

		  //총페이지구하기
		  //총페이지갯수/한페이지에 보여질 갯수로 나눔(7/5=1)
		  //나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 필요)
		 	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1); 
		  
		  //각블럭당 보여질 시작페이지
		  //perBlock=5일경우 현재페이지 1~5일경우는 시작페이지1,끝5
		  //만약 현재페이지가 13 시작:11  끝:15
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1; 
		  
		  //총페이지갯수가 23일경우 마지막 25가 아니라 23
		  if(endPage>totalPage)
			  endPage=totalPage;
		  
		  //각페이지에서 보여질 시작번호(5개의 글을 한페이지)
		  //예: 1페이지->0  2페이지: 5  3페이지:10.. 
		  startNum=(currentPage-1)*perPage;
		  
		  no=totalCount-(currentPage-1)*perPage;
		  

		List<BoardDto> list = dao.selectBoard(startNum, perPage);
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
	public String content(@RequestParam int num, Model model) {
		BoardDto dto = dao.selectContent(num);
		model.addAttribute("dto", dto);

		return "board/content";
	}
}
