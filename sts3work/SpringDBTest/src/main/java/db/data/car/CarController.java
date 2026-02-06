package db.data.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

	@Autowired
	CarDao dao;

	@GetMapping("/carinfo/list")
	public String list(Model model) {

		List<CarDto> list = dao.getAllList();
		model.addAttribute("count", dao.getTotalCount());
		model.addAttribute("list", list);

		return "cinfo/carlist";
	}

	@GetMapping("/carinfo/writeform")
	public String form() {
		return "cinfo/addform";
	}

	@PostMapping("/carinfo/write")
	public String insert(@ModelAttribute CarDto dto) {

		dao.insertCar(dto);
		return "redirect:list";
	}

	@GetMapping("/carinfo/delete")
	public String delete(@RequestParam int num) {
		dao.deleteCar(num);
		return "redirect:list";
	}

	@GetMapping("/carinfo/updateform")
	public String updateform(@RequestParam int num,Model model) {
		
		CarDto dto=dao.selectCar(num);
		model.addAttribute("dto",dto);
		
		return "cinfo/updateform";
	}
	
	@PostMapping("/carinfo/update")
	public String update(@ModelAttribute CarDto dto) {

		dao.updateCar(dto);
		return "redirect:list";
	}

}
