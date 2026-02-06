package board.data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("TotalCountBoard");
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertBoard",dto);
	}

	@Override
	public List<BoardDto> selectBoard(int start,int perpage) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return sqlSession.selectList("selectBoard",map);
	}

	@Override
	public BoardDto selectContent(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectContent",num);
	}

}
