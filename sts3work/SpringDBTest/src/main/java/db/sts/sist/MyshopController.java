package db.sts.sist;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyshopController {

	@Autowired
	MyshopDao dao;

	/*
	 * @GetMapping("/") public String home() {
	 * 
	 * return "redirect:myshop/list"; }
	 */
	@GetMapping("/myshop/list")
	public String home(Model model) {

		List<MyshopDto> list = dao.getAllSangpums();

		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "myshop/list";
	}

	@GetMapping("/myshop/addform")
	public String addForm() {
		return "myshop/addform";
	}

	@PostMapping("/myshop/add")
	public String insert(@ModelAttribute MyshopDto dto, @RequestParam ArrayList<MultipartFile> upload,
			HttpSession session) {

		// 업로드실제경로
		String path = session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		// 파일명에 현재날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");

		String photo = "";

		if (upload.get(0).getOriginalFilename().equals("")) {
			photo = "no-image";
		} else {
			for (MultipartFile f : upload) {
				String fName = sdf.format(new Date()) + f.getOriginalFilename();
				photo += fName + ",";

				// 업로드
				try {
					f.transferTo(new File(path + "\\" + fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			photo = photo.substring(0, photo.length() - 1);
		}
		dto.setPhoto(photo);

		dao.insertMyshop(dto);

		return "redirect:list";
	}

	@GetMapping("/myshop/detail")
	public ModelAndView detail(@RequestParam int num) {

		ModelAndView mav = new ModelAndView();

		MyshopDto dto = dao.getData(num);
		mav.addObject("dto", dto);

		mav.setViewName("myshop/detailView");
		return mav;

	}

	@GetMapping("/myshop/delete")
	public String delete(@RequestParam int num, HttpSession session) {

		// photo에 업로드된 사진 삭제
		String oldphoto = dao.getData(num).getPhoto();

		if (!oldphoto.equals("no")) {
			// ,로 분리해서 배열에 넣기
			String[] fName = oldphoto.split(",");
			// 실제경로
			String path = session.getServletContext().getRealPath("/WEB-INF/photo");

			for (String f : fName) {
				File file = new File(path + "\\" + f);
				file.delete();
			}
		}

		// db삭제
		dao.deleteMyshop(num);

		return "redirect:list";
	}
}
