package sts.mvc.day0204;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@GetMapping("/upload/uploadform1")
	public String form1() {
		return "upload/uploadform1";
	}

	@PostMapping("/upload/uploadproc1")
	public ModelAndView result1(@RequestParam String title, @RequestParam MultipartFile photo,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		// 업로드 실제 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(realPath);

		String fileName = photo.getOriginalFilename();

		if(!fileName.equals("")) {
			try {
				photo.transferTo(new File(realPath+"\\"+fileName)); //실제업로드
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			fileName="no";
		}
		
		mav.addObject("fileName", fileName);
		mav.addObject("title", title);
		mav.addObject("realPath", realPath);
		mav.setViewName("upload/uploadresult1");
		return mav;
	}

	@GetMapping("/upload/uploadform2")
	public String form2() {
		return "upload/uploadform2";
	}
	
	@PostMapping("/upload/uploadproc2")
	public ModelAndView result2(@RequestParam String title, @RequestParam ArrayList<MultipartFile> photo,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		// 업로드 실제 경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(realPath);

		ArrayList<String> files=new ArrayList<String>();

		for(MultipartFile f:photo) {
			String fileName=f.getOriginalFilename();
			files.add(fileName);
			
			try {
				f.transferTo(new File(realPath+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		mav.addObject("files", files);
		mav.addObject("title", title);
		mav.addObject("realPath", realPath);
		mav.setViewName("upload/uploadresult2");
		return mav;
	}
}
