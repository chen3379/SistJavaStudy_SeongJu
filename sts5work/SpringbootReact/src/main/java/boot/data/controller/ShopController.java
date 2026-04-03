package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.ShopDto;
import boot.data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService service;

	String photoName; // react에서 업로드한 이미지명

	@PostMapping("/upload")
	public String fileUpload(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request) {

		// 파일명
		String fileName = uploadFile.getOriginalFilename();

		// 업로드할 폴더위치
		String path = request.getServletContext().getRealPath("/save");

		// 직전에 업로드한 이미지 삭제
		File file = new File(path + "/" + photoName);
		if (file.exists())
			file.delete();

		// 파일명 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		photoName = sdf.format(new Date()) + uploadFile.getOriginalFilename();
		System.out.println("fileName: " + fileName + "==>" + photoName);

		// save에 업로드
		try {
			uploadFile.transferTo(new File(path + "/" + photoName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return photoName;
	}
	
	@PostMapping("/insert")
	public void insertShop(@RequestBody ShopDto dto) {
		//업로드한 이미지
		dto.setPhoto(photoName);
		service.insertShop(dto);
		
		photoName=null; //전역변수가 null이므로 맞춰준다
		//insert된 후 다시 비워두기 위해서 
	}
}
