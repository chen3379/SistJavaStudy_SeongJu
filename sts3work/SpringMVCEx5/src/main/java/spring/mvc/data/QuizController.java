package spring.mvc.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.SawonDto;

@Controller
public class QuizController {

	@GetMapping("/")
	public String home() {
		return "data/home";
	}
	
	@GetMapping("/quiz/form")
	public String quiz() {
		return "quiz/myform";
	}
	
	@PostMapping("/quiz/info")
	public ModelAndView sawoninfo(SawonDto dto) {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("dto", dto);
		mav.setViewName("quiz/sawoninfo");
	
		return mav;
	}
}
