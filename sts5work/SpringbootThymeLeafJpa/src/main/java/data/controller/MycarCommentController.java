package data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dao.MycarCommentDao;
import data.dto.MycarCommentDto;
import data.dto.MycarDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // final 이나 @NonNull 멤버변수만 자동주입
public class MycarCommentController {

	private final MycarCommentDao commentDao;

	@GetMapping("/addcomment")
	public void addComment(@RequestParam("num") Long num, @RequestParam("comment") String comment) {

		// MycarDto에 num 값을 넣은 후 MycarCommentDto에 넣는다 (외부키로 지정된 값)
		MycarDto dto = MycarDto.builder().num(num).build();

		// DTO에 값 저장
		MycarCommentDto cdto = MycarCommentDto.builder().comment(comment).mycar(dto).build();

		// DB insert
		commentDao.insertCommentMycar(cdto);
	}

	// 원글에 달린 댓글 반환
	@GetMapping("/commentlist")
	public List<MycarCommentDto> commentList(@RequestParam("num") Long num) {
		return commentDao.getMycarCommentList(num);
	}
}
