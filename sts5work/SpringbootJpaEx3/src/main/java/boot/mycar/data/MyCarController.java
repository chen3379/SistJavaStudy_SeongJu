package boot.mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyCarController {

	@Autowired
	MyCarDao dao;

	@GetMapping("/mycar/addform")
	public String form() {
		return "addform";
	}

	// insert
	@PostMapping("/mycar/insert")
	public String insert(@ModelAttribute MyCarDto dto) {
		dao.insertMyCar(dto);

		return "redirect:carlist";
	}

	// list
	@GetMapping("/mycar/carlist")
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();

		List<MyCarDto> list = dao.getAllDatas();

		mav.addObject("list", list);
		mav.addObject("count", list.size());

		mav.setViewName("carlist");
		return mav;
	}

	// 수정폼 띄우기
	@GetMapping("/mycar/updateform")
	public ModelAndView updateform(@RequestParam long num) {
		ModelAndView mav = new ModelAndView();
		MyCarDto dto = dao.getData(num);
		mav.addObject("dto", dto);
		
		mav.setViewName("updateform");
		return mav;
	}

	// 수정
	@PostMapping("/mycar/update")
	public String update(@ModelAttribute MyCarDto dto) {
		dao.updateMyCar(dto);

		return "redirect:carlist";
	}
	
	// 삭제
	@GetMapping("/mycar/delete")
	public String delete(@RequestParam long num) {
		dao.deleteMyCar(num);
		
		return "redirect:carlist";
	}
}
