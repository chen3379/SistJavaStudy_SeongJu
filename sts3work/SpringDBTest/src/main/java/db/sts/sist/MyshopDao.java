package db.sts.sist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyshopDao {

	@Autowired
	private SqlSession session;
	
	public List<MyshopDto> getAllSangpums(){
		
		return session.selectList("getAllOfMyshop");
	}
}
