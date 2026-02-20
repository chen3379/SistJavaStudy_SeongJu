package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dao.MycarDao;
import data.dao.MycarDaoInter;
import data.dto.MycarDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MycarController {

	private final MycarDaoInter mycarDaoInter;

	private final MycarDao mycardao;

	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}

	@GetMapping("/list")
	public String list(Model model) {

		List<MycarDto> list = mycardao.getAllCars();

		// request 저장
		model.addAttribute("list", list);
		model.addAttribute("totalCount", list.size());

		// forward
		return "mycar/mycarlist";
	}

	// 입력폼 이동
	@GetMapping("/addcar")
	public String list() {
		return "mycar/addform";
	}

	// insert
	@PostMapping("/insert")
	public String insertCar(@ModelAttribute MycarDto dto, @RequestParam("carupload") MultipartFile carupload,
			HttpSession session) {

		String realPath = session.getServletContext().getRealPath("/carsave");
		System.out.println(realPath);

		String uploadName = carupload.getOriginalFilename();

		dto.setCarphoto(uploadName);

		try {
			carupload.transferTo(new File(realPath + "\\" + uploadName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mycardao.insertMycar(dto);

		return "redirect:list";
	}

	// detailpage
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam("num") Long num) {

		MycarDto dto = mycardao.getCar(num);
		
		model.addAttribute("dto", dto);

		return "mycar/mycardetail";
	}
	
	// 수정폼 이동
		@GetMapping("/updatecar")
		public String updateform(@RequestParam("num") Long num,Model model) {
			
			MycarDto dto= mycardao.getCar(num);
			model.addAttribute("dto", dto);
			
			return "mycar/updateform";
		}

		// update
		@PostMapping("/update")
		public String updateCar(@ModelAttribute MycarDto dto, @RequestParam("carupload") MultipartFile carupload,
				HttpSession session) {

			String realPath = session.getServletContext().getRealPath("/carsave");

			if(!carupload.isEmpty()) {
				
				String uploadName = carupload.getOriginalFilename();
				dto.setCarphoto(uploadName);
				
				try {
					carupload.transferTo(new File(realPath+"\\"+uploadName));
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				MycarDto existingDto = mycardao.getCar(dto.getNum());
				dto.setCarphoto(existingDto.getCarphoto());
			}
			
			mycardao.updateMycar(dto);

			return "redirect:detail?num="+dto.getNum();
		}

		//delete
		@GetMapping("/delete")
		public String delete(@RequestParam("num") Long num) {
			
			mycardao.deleteMyCar(num);
			
			return "redirect:list";
		}
}
