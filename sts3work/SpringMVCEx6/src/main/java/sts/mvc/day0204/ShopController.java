package sts.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.ShopDto;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@GetMapping("/list")
	public String list() {
		return "shop/list";
	}

	@GetMapping("/shopform")
	public String shopform() {
		return "shop/shopform";
	}

	@PostMapping("/process2")
	public ModelAndView shopresult(@ModelAttribute ShopDto dto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);

		mav.setViewName("shop/shopresult");

		return mav;
	}
}
