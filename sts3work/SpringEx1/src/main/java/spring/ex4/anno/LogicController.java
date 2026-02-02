package spring.ex4.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //logicController로 등록,단 이름을 주면 그 이름으로 id
public class LogicController {
//	MyDao dao;
	@Autowired //자동주입
	DaoInter dao;

	// insert
	public void insert(String str) {
		dao.insertData(str);
	}

	// delete
	public void delete(String num) {
		dao.deleteData(num);
	}

}