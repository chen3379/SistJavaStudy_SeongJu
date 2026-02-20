package data.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import data.dto.MycarCommentDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarCommentDao {

	private MycarCommentDaoInter commentDaoInter;
	
	// 댓글 저장
	public void insertCommentMycar(MycarCommentDto dto) {
		
		commentDaoInter.save(dto);
	}
	
	// 댓글 출력
	public List<MycarCommentDto> getMycarCommentList(Long num) {
		
		return commentDaoInter.getMycarCommentList(num);
	}
	
}
