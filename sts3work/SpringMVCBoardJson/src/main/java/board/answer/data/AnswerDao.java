package board.answer.data;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao implements AnswerDaoInter {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertAnswer",dto);
	}

	@Override
	public List<AnswerDto> selectAll(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("answerList",num);
	}

	@Override
	public int getCheckPass(int idx, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("pass", pass);
		
		return sqlSession.selectOne("passCheckAnswer", map);
	}

	@Override
	public void deleteAnswer(int idx) {
		// TODO Auto-generated method stub
		sqlSession.delete("deleteAnswer",idx);
	}

}
