package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import boot.data.dto.MarketDto;
import boot.data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {

	@Autowired
	MarketMapperInter mapper;

	@GetMapping("/")
	public String start() {
		return "redirect:market/list";
	}

	@GetMapping("market/list")
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();

		// DB로부터 총갯수 얻기
		int count = mapper.getTotalCount();

		// 전체 목록 얻기
		List<MarketDto> list = mapper.getAllSangpums();

		// request에 저장
		mav.addObject("totalcount", count);
		mav.addObject("list", list);

		// forward
		mav.setViewName("marketlist");

		return mav;
	}

	// 입력폼으로 이동
	@GetMapping("market/form")
	public String form() {
		return "addform";
	}

	// 상품 등록
	@PostMapping("market/add")
	public ModelAndView insert(@ModelAttribute MarketDto dto, @RequestParam MultipartFile photo, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		// 업로드 경로
		String path = session.getServletContext().getRealPath("/photo");

		System.out.println(path);

		if (photo.getOriginalFilename().equals(""))
			dto.setPhotoname(null);
		else {

			// 사진명 앞에 현재 날짜 시분초
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

			String photoname = sdf.format(new Date()) + photo.getOriginalFilename();
			dto.setPhotoname(photoname);

			try {
				photo.transferTo(new File(path + "\\" + photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// DB에 저장
		mapper.insertMarket(dto);

		mav.addObject("dto", dto);

		mav.setViewName("redirect:list");

		return mav;
	}

	// 수정폼으로 이동
	@GetMapping("market/updateform")
	public ModelAndView updateform(@RequestParam String num) {
		ModelAndView mav = new ModelAndView();

		MarketDto dto = mapper.getSangpum(num);

		mav.addObject("dto", dto);
		mav.setViewName("updateform");
		return mav;
	}

	// 수정
	@PostMapping("market/update")
	public ModelAndView update(@ModelAttribute MarketDto dto, @RequestParam MultipartFile photo, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		// 업로드 경로
		String path = session.getServletContext().getRealPath("/photo");

		System.out.println(path);

		if (photo.getOriginalFilename().equals(""))
			dto.setPhotoname(null);
		else {

			// 수정 전에 기존 사진 지우기
			String oldphoto = mapper.getSangpum(dto.getNum()).getPhotoname();

			File file = new File(path + "\\" + oldphoto);
			// 파일 삭제
			file.delete();

			// 사진명 앞에 현재 날짜 시분초
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

			String photoname = sdf.format(new Date()) + photo.getOriginalFilename();
			dto.setPhotoname(photoname);

			try {
				photo.transferTo(new File(path + "\\" + photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// DB에 저장
		mapper.updateMarket(dto);

		mav.addObject("dto", dto);

		mav.setViewName("redirect:list");

		return mav;
	}

	// 삭제
	@GetMapping("market/delete")
	public String delete(@RequestParam String num, HttpSession session) {

		String path = session.getServletContext().getRealPath("/photo");

		String delphoto = mapper.getSangpum(num).getPhotoname();

		File file = new File(path + "\\" + delphoto);
		// 파일 삭제
		file.delete();

		mapper.deleteMarket(num);

		return "redirect:list";
	}
}
