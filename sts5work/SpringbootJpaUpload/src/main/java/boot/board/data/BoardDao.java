package boot.board.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Autowired
	BoardDaoInter inter;

	// insert
	public void insertBoard(BoardDto dto) {

		inter.save(dto);
	}

	// 전체목록
	public List<BoardDto> getAllDatas() {
		return inter.findAll(Sort.by(Sort.Direction.DESC, "num"));
	}

	// 삭제
	public void deleteBoard(Long num) {
		inter.deleteById(num);
	}

	// 1개 조회
	public BoardDto getData(Long num) {
		return inter.getReferenceById(num);
	}
	
	//수정
	public void updateBoard(BoardDto dto) {
		inter.save(dto);
	}
}
