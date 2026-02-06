package sts.mvc.json;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		return "json/home";
	}
	@GetMapping("/ex1")
	public String ex1() {
		
		return "json/ex1";
	}
	@GetMapping("/ex2")
	public String ex2() {
		
		return "json/ex2";
	}
	
}
