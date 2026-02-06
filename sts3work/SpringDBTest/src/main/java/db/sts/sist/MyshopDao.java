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
	
	public void insertMyshop(MyshopDto dto) {
		session.insert("db.sts.sist.MyshopDao.insertOfMyshop",dto);
	}
	
	public MyshopDto getData(int num) {
		return session.selectOne("getOneOfMyshop",num);
	}
	
	public void deleteMyshop(int num) {
		session.delete("db.sts.sist.MyshopDao.deleteOfMyshop",num);
	}
}
