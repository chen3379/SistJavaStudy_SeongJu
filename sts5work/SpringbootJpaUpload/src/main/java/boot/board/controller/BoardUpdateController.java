package boot.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.board.data.BoardDao;
import boot.board.data.BoardDto;

@Controller
public class BoardUpdateController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/updateform")
	public ModelAndView updateform(@RequestParam Long num) {
		ModelAndView mav=new ModelAndView();
		BoardDto dto= dao.getData(num);
		mav.addObject("dto", dto);
		mav.setViewName("updateform");
		return mav;
	}
	
	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto) {
		dao.updateBoard(dto);
		
		return "redirect:list";
	}
}
