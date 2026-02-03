package spring.hello.hi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/login/form")
	public String form() {
		
		return "mystudy/form";
	}

	@GetMapping("/login/read")
	public String result(Model model,@RequestParam String myid,String mypass) {
		
		model.addAttribute("myid",myid);
		model.addAttribute("mypass",mypass);
		
		String msg="";
		if(mypass.equals("1234"))
			msg="로그인성공";
		else
			msg="로그인실패";
			model.addAttribute("loginmsg",msg);
		
		return "mystudy/result";
	}
}
