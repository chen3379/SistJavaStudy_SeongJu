package day1024;

import java.util.Random;

public class RandomTest_07 {
	
	public static void main(String[] args) {
		// 자바에서 난수를 구하는 방법 2가지
		// 1) Math.random() 메소드 활용
		// 2) Random 클래스를 생성해서 구하는 방법

		System.out.println("10개의 난수 발생\n");
		
		for(int i=1;i<=10;i++) {
			double n =Math.random();
			System.out.println((int)(10*n));
		}
		System.out.println("=======");
		
		for(int i=1;i<=10;i++) {
			double n =Math.random();
			System.out.println((int)(100*n));
		}
		System.out.println("=======");
		
		for(int i=1;i<=10;i++) {
			double n =Math.random();
			System.out.println((int)(10*n+1));
		}
		System.out.println("=======");
		
		for(int i=1;i<=10;i++) {
			double n =Math.random();
			System.out.println((int)(100*n+1));
		}
		System.out.println("=======");
		for(int i=1;i<=10;i++) {
			double n =Math.random();
			System.out.println((int)(45*n+1));
		}
		
		
		
		
		System.out.println("math class");
		int v= Math.abs(-5);
		System.out.println(v);
	}

}
