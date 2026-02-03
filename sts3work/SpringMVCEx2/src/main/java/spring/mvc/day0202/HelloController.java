package spring.mvc.day0202;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//사원명(sawonName), 부서명(buseo), 급여(pay)를 result3에서 출력하도록 해보세요
	
	@GetMapping("/apple/list")
	public String company(Model model) {
		
		model.addAttribute("sawonName","고윤정");
		model.addAttribute("buseo","인사과");
		model.addAttribute("pay","6000000");
		return "result3";
	}

	@GetMapping("/kakao/list")
	public ModelAndView klist(HttpSession session) {
		
		ModelAndView mav=new ModelAndView();
		//ModelAndView는 request에 저장하기 위한 Model과 포워드하기 위한 view를 합친 클래스
		//request에 저장
		mav.addObject("java",88);
		mav.addObject("spring",99);
		
		//session에 저장
		session.setAttribute("myid", "admin");
		//포워드할 jsp파일을 지정
		mav.setViewName("result4");
		
		return mav;
	}
	
}
