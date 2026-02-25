package boot.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	MemberService service;

	@GetMapping("/main")
	public String loginform(HttpSession session, Model model) {

		// 폼의 아이디
		String myid = (String) session.getAttribute("myid");
		// 로그인상태인지 아닌지
		String loginok = (String) session.getAttribute("loginok");

		if (loginok == null)
			return "login/loginform";
		else {
			String name=service.getName(myid);
			model.addAttribute("loginname", name);
			
			return "login/logoutform";
		}
	}

	@PostMapping("/loginprocess")
	public String loginProc(@RequestParam(required = false) String cbsave, @RequestParam String id,
			@RequestParam String pass, HttpSession session, Model model) {

		int logincheck = service.loginCheck(id, pass);

		if (logincheck == 1) {
			session.setMaxInactiveInterval(60 * 60 * 8);

			session.setAttribute("myid", id);
			session.setAttribute("loginok", "yes");
			session.setAttribute("saveok", cbsave);

			// session에 dto 멤버값 저장
			MemberDto mdto = service.getDataById(id);
			session.setAttribute("loginphoto", mdto.getPhoto());

			return "redirect:main";
		} else {

			return "login/passfail";
		}

	}
	// 아웃처리
	@GetMapping("/logoutprocess")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginok");
		return "redirect:main";
	}
}
