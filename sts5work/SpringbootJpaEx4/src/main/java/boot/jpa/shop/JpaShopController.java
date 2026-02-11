package boot.jpa.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpaShopController {

	@Autowired
	JpaShopDao dao;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/myjpa/addshop")
	public String addform() {
		return "addform";
	}

	@GetMapping("/myjpa/updateshop")
	public ModelAndView updateform(@RequestParam int num) {
		ModelAndView model=new ModelAndView();
		
		ShopDto dto=dao.getSangpum(num);
		
		model.addObject("dto", dto);
		model.setViewName("updateform");
		
		return model;
	}

	@PostMapping("/myjpa/updateshop")
	public String update(@ModelAttribute ShopDto dto)
	{
		//수정
		dao.updateShop(dto);
		
		return "redirect:shoplist";
	}

	@PostMapping("/myjpa/add")
	public String add(@ModelAttribute ShopDto dto) {

		dao.insertShop(dto);

		return "redirect:shoplist";
	}

	@GetMapping("/myjpa/shoplist")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();

		List<ShopDto> list = dao.getAllSangpums();

		model.addObject("list", list);
		model.addObject("count", list.size());
		model.setViewName("shoplist");

		return model;
	}
	
	@GetMapping("/myjpa/delete")
	public String delete(@RequestParam int num) {
		dao.deleteShop(num);
		
		return "redirect:shoplist";
	}
}

