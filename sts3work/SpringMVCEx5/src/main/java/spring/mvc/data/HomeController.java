package spring.mvc.data;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.dto.TestDto;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "data/home";
	}
	
	@GetMapping("/data/myform")
	public String myform() {
		return "data/form";
	}
	
	//폼1
	@GetMapping("/data/read1")
	public ModelAndView read1(@RequestParam String name,@RequestParam int age) {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("name", name);
		mav.addObject("age", age);
		
		mav.setViewName("data/result1");
		
		return mav;
	}
	//폼2
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute TestDto dto) {
		ModelAndView mav=new ModelAndView();
	
		mav.addObject("dto", dto);
		
		mav.setViewName("data/result2");
		
		return mav;
	}
	//폼3
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		ModelAndView mav=new ModelAndView();
		
		String sang=map.get("sang");
		String sprice=map.get("sprice");
		
		String data=sang+" 제품의 가격은 "+sprice+"원 입니다";
		mav.addObject("data", data);
		
		mav.setViewName("data/result3");
		
		return mav;
	}
}
