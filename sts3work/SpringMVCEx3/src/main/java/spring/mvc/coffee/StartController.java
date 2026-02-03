package spring.mvc.coffee;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {

	@GetMapping("/")
	public String Start() {
		
		return "mypage/home";
	}
	
	@GetMapping("/coffee/star")
	public String Start1(Model model) {
		model.addAttribute("name","고윤정");
		model.addAttribute("hp","010-2345-6789");
		model.addAttribute("job","배우");
		
		return "mypage/study1";
	}
	
	@GetMapping("/coffee/bean")
	public ModelAndView Start2(HttpSession session) {
		
		ModelAndView mav=new ModelAndView();
		
		session.setAttribute("sessionid", "cha");
		session.setAttribute("pass", "1234");
		session.setAttribute("email", "muhee@gmail.com");
		
		mav.setViewName("mypage/study2");
		return mav;
	}
	
	@GetMapping("/pink/add/list")
	public String Start3() {
		
		return "mypage/study3";
	}
}
