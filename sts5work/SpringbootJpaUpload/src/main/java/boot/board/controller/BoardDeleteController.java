package boot.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.board.data.BoardDao;

@Controller
public class BoardDeleteController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam Long num) {
		dao.deleteBoard(num);
		
		return "redirect:list";
	}
}
