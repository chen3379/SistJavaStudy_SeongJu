package com.boot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.dto.InfoDto;

@Controller
@RequestMapping("/my")
public class FormReadController {

	// 폼1의 컬럼을 각각 읽어서 result1으로 보낸다
	@PostMapping("/read1")
	public String read1(Model model, @RequestParam String name, @RequestParam String java,
			@RequestParam String spring) {
		model.addAttribute("name", name);
		model.addAttribute("java", java);
		model.addAttribute("spring", spring);

		return "result/result1";
	}

	// 폼2의 컬럼을 Dto로 읽어서 result2으로 보낸다
	@PostMapping("/read2")
	public String read2(@ModelAttribute InfoDto dto) {
		return "result/result2";
	}

	// 폼3의 컬럼을 각각 읽어서 result3으로 보낸다
	@PostMapping("/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("irum", map.get("irum"));
		mav.addObject("blood", map.get("blood"));
		mav.addObject("hp", map.get("hp"));

		mav.setViewName("result/result3");
		return mav;
	}
}
