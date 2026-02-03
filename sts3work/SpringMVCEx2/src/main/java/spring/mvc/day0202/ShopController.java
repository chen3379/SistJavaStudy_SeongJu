package spring.mvc.day0202;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {


	@GetMapping("/shop/detail")
	public String shoplist() {
			
		return "imgresult";	
	}
	@GetMapping("/admin/shop/mypage")
	public String shoppage() {
		
		return "imgresult2";	
	}
	@GetMapping("/myshop")
	public String shop() {
		
		return "imgresult3";	
	}
}
