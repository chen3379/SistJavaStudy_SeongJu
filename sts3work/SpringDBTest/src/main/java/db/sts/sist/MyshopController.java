package db.sts.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyshopController {

	@Autowired
	MyshopDao dao;
	
	@GetMapping("/")
	public String home(Model model) {

		List<MyshopDto> list=dao.getAllSangpums();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "myshop/list";
	}

}
