package boot.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.IpgoDto;
import boot.data.service.IpgoService;
import jakarta.servlet.http.HttpSession;

@Controller
public class IpgoController {

	@Autowired
	IpgoService service;
	
	
	/*@GetMapping("/")
	public String start()
	{
		return "redirect:ipgo/list";
	}*/
	
	@GetMapping("/ipgo/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		int totalCount=service.getTotalCount();
		List<IpgoDto> list=service.getAllSangpums();
		
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		
		mview.setViewName("ipgo/ipgolist");
		
		return mview;
	}
	
	//입력폼 이동
	@GetMapping("/ipgo/ipgoform")
	public String form()
	{
		return "ipgo/ipgoform";
	}
	
	//insert
	@PostMapping("/ipgo/insert")
	public String insert(@ModelAttribute IpgoDto dto,ArrayList<MultipartFile> upload,HttpSession session)
	{
		
		service.insertIpgo(dto, upload, session);
		return "redirect:list";
	}
	
	
	
}
