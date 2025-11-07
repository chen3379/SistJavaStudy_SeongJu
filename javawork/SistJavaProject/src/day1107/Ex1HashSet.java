package day1107;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1HashSet {

	public static void main(String[] args) {
		
		Set<String> setTest = new HashSet<String>();
		
		setTest.add("a");
		setTest.add("b");
		setTest.add("c");
		setTest.add("d");
		setTest.add("a");
		setTest.add("d");
		setTest.add("e");
		
		System.out.println("#출력1");
		System.out.println(setTest);
		System.out.println("데이타 개수: "+setTest.size());
		
		System.out.println("#출력2+for");
		for(String s:setTest)
			System.out.println(s+" ");
		System.out.println("#출력3_Iterator");
		Iterator<String> iter=setTest.iterator();
		while (iter.hasNext()) {
			String s = (String) iter.next();
			System.out.println(s+" ");
			
		}
		System.out.println("#출력4_toArray()");
		Object [] ob=setTest.toArray();
		for(Object s:ob)
			System.out.println(s);
		
		setTest.clear();
		System.out.println(setTest);
		
			
	}
}
