package spring.ex4.anno;

import org.springframework.stereotype.Component;

@Component("mydao") //자동으로 빈에 등록(id가 클래스명, 단 첫글자가 소문자)myDao
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub
		System.out.println(str+"데이터를 db에 추가성공!!!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"번 시퀀스 데이터 삭제성공!!!");

	}

}
