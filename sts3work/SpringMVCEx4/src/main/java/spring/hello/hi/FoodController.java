package spring.hello.hi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

	@GetMapping("/")
	public String index() {
	
		return "index";
	}
	
	@GetMapping("/happy")
	public String image() {
		
		return "mystudy/mystudy01";
	}
	@GetMapping("/hello/my")
	public String msg(Model model) {
		
		model.addAttribute("msg", "계란토마토샌드위치");
		
		return "mystudy/mystudy02";
	}
	@GetMapping("/nice/hello")
	public String info(Model model) {
		
		model.addAttribute("name", "고윤정");
		model.addAttribute("addr", "서울시 강남구");
		model.addAttribute("age", "28");
		
		return "mystudy/mystudy03";
	}
}
