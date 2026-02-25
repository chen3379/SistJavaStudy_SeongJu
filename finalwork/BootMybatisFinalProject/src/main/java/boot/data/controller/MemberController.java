package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@GetMapping("/member/list")
	public String memberlist(Model model) {
		List<MemberDto> list = service.getAllMembers();

		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "member/memberlist";
	}

	@GetMapping("/member/form")
	public String memberform() {
		return "member/memberform";
	}

	// id 체크
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheckProcess(@RequestParam String id) {
		Map<String, Integer> map = new HashMap<>();

		int n = service.getSearchId(id);
		map.put("checkcount", n); // 0 or 1

		return map;
	}

	// insert 후 list 이동
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto, HttpSession session, MultipartFile myphoto) {
		service.insertMember(dto, session, myphoto);

//		if(dto.getId()!='admin')
		return "member/gaipsuccess";
	}

	// 나의정보로 가기(메뉴)
	@GetMapping("/member/myinfo")
	public String myinfo(Model model, @RequestParam String num) {

		List<MemberDto> list = service.getAllMembers();
		model.addAttribute("list", list);
		MemberDto dto = service.getMember(num);
		model.addAttribute("dto", dto);
		return "member/myinfo";
	}

	// 삭제 ajax
	@GetMapping("/member/delete")
	@ResponseBody
	public void delete(@RequestParam String num) {
		service.deleteMember(num);
	}

	// myinfo에서 사진만 변경하기 ajax
	@PostMapping("/member/updatephoto")
	@ResponseBody
	public void updatePhoto(String num, MultipartFile photo, HttpSession session) {
		String path = session.getServletContext().getRealPath("/membersave");
		System.out.println(path);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		String fileName = sdf.format(new Date()) + photo.getOriginalFilename();
		try {
			photo.transferTo(new File(path + "\\" + fileName));

			service.updatePhoto(num, fileName);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@GetMapping("/member/updateinfo")
	public String updateform(Model model,String num) {

		MemberDto dto=service.getMember(num);
		model.addAttribute("dto", dto);
		
		return "member/updateform";
	}

	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {

		service.updateMember(dto);

		return "redirect:myinfo?num="+dto.getNum();
	}

}
