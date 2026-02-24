package boot.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/member/list")
	public String memberlist(Model model)
	{
		List<MemberDto> list=service.getAllMembers();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "member/memberlist";
	}
	
	@GetMapping("/member/form")
	public String memberform()
	{
		return "member/memberform";
	}
	
	//id 체크
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheckProcess(@RequestParam String id){
		Map<String, Integer> map=new HashMap<>();
		
		int n=service.getSearchId(id);
		map.put("checkcount", n); //0 or 1
		
		return map;
	}
}
