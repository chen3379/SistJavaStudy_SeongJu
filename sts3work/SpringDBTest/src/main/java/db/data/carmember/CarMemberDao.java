package db.data.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void insertCarmember(CarMemberDto dto) {
		sqlsession.insert("insertMember",dto);
		
	}

	@Override
	public List<CarMemberDto> getAllMembers() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("selectAllMember");
	}

	@Override
	public void deleteMember(int num) {
		sqlsession.delete("deleteMember",num);
		
	}

	@Override
	public void updateMember(CarMemberDto dto) {
		sqlsession.update("updateMember",dto);
		
	}

	@Override
	public CarMemberDto selectCarMember(int num) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("selectMember",num);
	}

}
