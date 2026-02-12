package boot.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.board.data.BoardDao;
import boot.board.data.BoardDto;

@Controller
public class BoardListController {

	@Autowired
	BoardDao dao;

	@GetMapping("/")
	public String home() {
		return "redirect:board/list";
	}
	
	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDto> list = dao.getAllDatas();
		mav.addObject("list", list);
		mav.addObject("count", list.size());
		mav.setViewName("boardlist");

		return mav;
	}
	
	@GetMapping("/board/detailpage")
	public ModelAndView detail(Long num) {
		ModelAndView mav = new ModelAndView();
		BoardDto dto= dao.getData(num);
		mav.addObject("dto", dto);
		mav.setViewName("detailpage");

		return mav;
	}

}
