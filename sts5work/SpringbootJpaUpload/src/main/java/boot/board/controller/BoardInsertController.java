package boot.board.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import boot.board.data.BoardDao;
import boot.board.data.BoardDto;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardInsertController {

	@Autowired
	BoardDao dao;

	// insertform이동
	@GetMapping("/board/addform")
	public String form() {
		return "writeform";
	}

	@PostMapping("/board/write")
	public String insert(@ModelAttribute BoardDto dto, MultipartFile upload, HttpSession session) {
		// get path to save the image
		String path = session.getServletContext().getRealPath("/boardsave");
		System.out.println("path:" + path);

		// get the name of the uploaded file
		String uploadName = upload.getOriginalFilename();

		// set the photo name in the dto
		if (upload.isEmpty())
			dto.setPhoto("no");
		else
			dto.setPhoto(uploadName);
		try {
			upload.transferTo(new File(path + "\\" + uploadName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// save the BoardDto (including the photo name) to the database
		dao.insertBoard(dto);

		return "redirect:list"; // redirect to the board list after insertion
	}
}
