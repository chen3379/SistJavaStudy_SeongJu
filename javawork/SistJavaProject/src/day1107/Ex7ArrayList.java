package day1107;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex7ArrayList {

	public static void main(String[] args) {
		String[] name = { "Anna", "Ben", "Chris", "David", "Eden" };

		// ArrayList: 객체들을 삽입,삭제,검색할 수 있는 컨테이너
		// List<String> nameList=new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();

		// 데이타 담기
		// name을 list에 삽입해본다
		for (String s : name)
			nameList.add(s);
		// list를 출력해 본다(출력방법은 2개 이상 해볼 것)
		for (String s : nameList)
			System.out.print(s + " ");
		System.out.println();
		Iterator<String> iter = nameList.iterator();
		while (iter.hasNext()) {
			String s = (String) iter.next();
			System.out.print(s + " ");

		}
	}
}
