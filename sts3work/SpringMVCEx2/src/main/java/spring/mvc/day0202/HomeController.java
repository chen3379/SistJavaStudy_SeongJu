package spring.mvc.day0202;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	// @RequestMapping(value = "/",method = RequestMethod.GET)

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/dragon/sist.do") //sist 뒤에 .do, .nhn 뭐를 붙이든 다 호출 가능
	public String hello1(Model model) {

		// model: request에 데이터를 저장하는 클래스
		// 서블릿에서 request.setAttribute와 같다

		model.addAttribute("name", "손흥민");
		model.addAttribute("addr", "서울 강남구");

		return "result1"; // web-inf/day0202/result1.jsp 의미
	}

	@GetMapping("/naver/shop")
	public String hello2(Model model) {
		model.addAttribute("sangpum", "요가매트");
		model.addAttribute("color", "레드");
		model.addAttribute("price", "25000");
		
		return "result2";
	}

}
