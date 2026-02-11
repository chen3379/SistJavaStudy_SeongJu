package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import boot.data.dto.FoodDto;

@Controller
public class QuizController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/quiz/form")
	public String form() {
		return "addform";
	}
	
	@PostMapping("/quiz/foodshow")
	public String show(@ModelAttribute("dto") FoodDto dto ) {
		return "foodshow";
	}
}
