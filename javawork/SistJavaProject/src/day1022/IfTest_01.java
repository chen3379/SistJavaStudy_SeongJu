package day1022;

import java.util.Scanner;

public class IfTest_01 {

	public static void main(String[] args) {

		// int n=3;

		Scanner sc = new Scanner(System.in);
		int n;

		//		System.out.println("숫자를 입력해주세요");
		//		n=sc.nextInt();
		//
		//		// 조건 1개
		//		if(n>5) {
		//			System.out.println("n은 5보다 크다");
		//			System.out.println("n 최고");
		//		}
		//
		//		System.out.println("프로그램 종료!!!");


		// 조건 2개 홀수 짝수

		System.out.println("숫자를 입력해주세요");
		int a=sc.nextInt();

		if(a%2==1) {
			System.out.println(a+"는 홀수입니다");
		}
		else {
			System.out.println(a+"는 짝수입니다");
		}


	}

}
