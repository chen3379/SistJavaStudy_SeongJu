package day1107;

import java.util.Iterator;
//import java.util.List;
import java.util.Vector;

//List
//순차적으로 데이타가 들어간다(인덱스)
//중복데이타 허용
//처음 생성시 일정한 갯수로 생성, 그 이상의 데이타 넣으면 공간이 자동으로 늘어난다(가변적)
//생성자(5,3)_할당 크기가 5이고 혹시 넘치면 3씩 증가
public class Ex3Vector {

	public static void main(String[] args) {
		
//		List<String> list=new Vector<String>();
		Vector<String> list=new Vector<String>();
		
		System.out.println("초기 할당 크기: "+list.capacity());//리스트 할당 크기 10
		
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		list.add("키위");
		list.add("오렌지");
		list.add("키위");
		
		
		
		System.out.println("요소 개수: "+list.size());//6 중복 허용
		
		System.out.println("할당 크기: "+list.capacity());//할당 크기가 10 넘을 시 크기 10 증가
		
		System.out.println("출력#1_for");
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");//list.get(index)를 통해 배열 인덱스를 지정해서 불러올 수 있음
		System.out.println();
		
		for(String a:list)
			System.out.print(a+" ");
		System.out.println();
		
		Iterator<String> iter=list.iterator();
		while (iter.hasNext()) {
			String s = (String) iter.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		Object[] ob=list.toArray();
		for(int i=0;i<ob.length;i++)
			System.out.print(ob[i]+" ");
		
		System.out.println("\n"+list.get(1));
	}
}
