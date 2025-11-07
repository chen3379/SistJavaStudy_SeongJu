package day1106;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//set: 순서 유지X, 중복 허용X
//set: 인터페이스 HashSet: set 을 구현한 클래스
//Set<Generic Type> 참조변수명=new HashSet<Generic Type>();
public class Ex6HashSet {

	public static void main(String[] args) {
		// set 안에 String 이라는 자료형의 데이타만 담겠다
		Set<String> setTest = new HashSet<String>();
		
		// 추가, 삭제가 가능한 게 배열과의 차이점_가변적이다
		setTest.add("a");
		setTest.add("b");
		setTest.add("c");
		setTest.add("d");
		setTest.add("a");
		setTest.add("f");
		setTest.add("d");
		
		System.out.println("#출력1");
		System.out.println(setTest);
		System.out.println("데이타 개수: "+setTest.size());
		
		System.out.println("#출력2_for");
		for(String s:setTest)
			System.out.print(s+" ");
		
		System.out.println("\n#출력3_Iterator");
		Iterator<String> iter=setTest.iterator();
		while(iter.hasNext()) {
			String s= iter.next();
			System.out.print(s+" ");
		}
		System.out.println("\n#출력4_toArray()");
		Object [] ob=setTest.toArray();
		for(int i=0;i<ob.length;i++)
			System.out.print(ob[i]+" ");
		
		//모든 데이터 삭제
		setTest.clear();
		System.out.println("\n"+setTest);
		
		//isEmpty()
		if(setTest.isEmpty())
			System.out.println("Set 타입 안에 데이터가 없다");
		else
			System.out.println("Set 타입 안에 데이터가 있다");
	}
}
