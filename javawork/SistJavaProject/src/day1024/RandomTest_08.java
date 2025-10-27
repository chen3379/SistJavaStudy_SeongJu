package day1024;

import java.util.Random;

public class RandomTest_08 {

	public static void main(String[] args) {

		// 2. Random 클래스를 생성해서 구하는 방법

		Random r = new Random();

		System.out.println("0~9 사이의 난수 5개 발생\n");

		for(int i=1;i<=5;i++) {
			int n=r.nextInt(10);
			System.out.println(n);
		}
		
		System.out.println("=========================");
		System.out.println("1~10 사이의 난수 5개 발생\n");

		for(int i=1;i<=5;i++) {
			int n=r.nextInt(10);
			System.out.println(n+1);
		}
		
		System.out.println("=========================");
		System.out.println("A~Z 사이의 난수 5개 발생\n");

		for(int i=1;i<=5;i++) {
			int n=r.nextInt(26)+65; // 65~90
			System.out.println((char)n);
		}
		
		System.out.println("=========================");
		System.out.println("20~30 사이의 난수 5개 발생\n");

		for(int i=1;i<=5;i++) {
			int n=r.nextInt(11)+20; // 20~30
			System.out.println(n);
		}



	}

}
