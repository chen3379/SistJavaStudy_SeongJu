package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@ResponseBody
	@GetMapping("/board/list")
	public ModelAndView list() {
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("name", "쌍용교육센터");
		mav.addObject("addr", "서울시 강남구");
		
		mav.setViewName("list"); // board/list
		return mav;
	}
}
