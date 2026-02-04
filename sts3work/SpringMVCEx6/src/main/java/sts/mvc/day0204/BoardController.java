package sts.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/")
	public String home() {

		return "home";
	}

	@GetMapping("/form1")
	public String form1() {
		return "board/writeform";
	}

	@PostMapping("/result")
	public ModelAndView result(@RequestParam String name, @RequestParam String date, @RequestParam String gender,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(required = false) String msg) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("name", name);
		mav.addObject("date", date);
		mav.addObject("gender", gender);
		mav.addObject("currentPage", currentPage);
		mav.addObject("msg", msg);

		mav.setViewName("board/result");

		return mav;
	}
	
	@GetMapping("/result2")
	public String result2(Model model) {
		model.addAttribute("food10", "../image/Food/10.jpg");
		model.addAttribute("title", "내가 좋아하는 음식");
		
		
		return "board/result2";
	}


}
