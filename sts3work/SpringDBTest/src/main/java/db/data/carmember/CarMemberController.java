package db.data.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarMemberController {

	@Autowired
	CarMemberDao dao;
	
	@GetMapping("/carmember/list")
	public String list(Model model) {
		List<CarMemberDto> list=dao.getAllMembers();
		model.addAttribute("list",list);
		return "cmember/list";
	}
	@GetMapping("/carmember/addform")
	public String insertform() {
		return "cmember/addform";
	}
	@PostMapping("/carmember/insert")
	public String insert(CarMemberDto dto) {
		dao.insertCarmember(dto);
		return "redirect:list";
	}
	@GetMapping("/carmember/delete")
	public String delete(@RequestParam int num) {
		dao.deleteMember(num);
		
		return "redirect:list";
	}
	@GetMapping("/carmember/updateform")
	public String updateform(@RequestParam int num,Model model) {
		CarMemberDto dto=dao.selectCarMember(num);
		model.addAttribute("dto",dto);
		return "cmember/updateform";
	}
	@PostMapping("/carmember/update")
	public String update(CarMemberDto dto) {
		dao.updateMember(dto);
		
		return "redirect:list";  
	}
}
