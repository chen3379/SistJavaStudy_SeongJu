package day1107;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1Test {

	public static void main(String[] args) {
//		Set<Integer> set1=new HashSet<Integer>();//다형성
		HashSet<Integer> set2=new HashSet<Integer>(); //가능 set=new set 불가능
		
		//추가
		set2.add(4);//Integer -> 문자 불가능
		set2.add(6);
		set2.add(6);//중복 불가능
		set2.add(3);
		set2.add(2);
		
		System.out.println("개수: "+set2.size());

		System.out.println("출력#1");
		for(int a:set2)
			System.out.print(a+" ");
		System.out.println("\n출력#2");
		Iterator<Integer> iter=set2.iterator();
		while (iter.hasNext()) {
			Integer integer = (Integer) iter.next();
			System.out.print(integer+" ");
		}
		System.out.println("\n출력#3");
		Object [] ob=set2.toArray();
		for(int i=0;i<ob.length;i++)
			System.out.print(ob[i]+" ");
		
		System.out.println("\n#초기화");
		set2.clear();
		System.out.println(set2);
		
		System.out.println("#isEmpty");
		if(set2.isEmpty())
			System.out.println("Empty");
		else
			System.out.println("No empty");
		
	}
}
