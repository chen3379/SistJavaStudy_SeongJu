package boot.data.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@RestController
public class AjaxLoginController {

	@Autowired
	MemberService service;

	@GetMapping("/member/login")
	public Map<String, String> loginproc(String id, String pass, HttpSession session) {
		Map<String, String> map = new HashMap<>();

		// 로그인 상태 1 or 0
		int check = service.loginCheck(id, pass);
		if (check == 1) {
			session.setMaxInactiveInterval(60 * 60 * 8);

			session.setAttribute("myid", id);
			session.setAttribute("loginok", "yes");

			// session에 dto 멤버값 저장
			MemberDto mdto = service.getDataById(id);
			session.setAttribute("loginphoto", mdto.getPhoto());
			session.setAttribute("loginname", mdto.getName());

		}

		map.put("result", check == 1 ? "success" : "fail");

		return map;
	}
	
	@GetMapping("/member/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
	}
}
