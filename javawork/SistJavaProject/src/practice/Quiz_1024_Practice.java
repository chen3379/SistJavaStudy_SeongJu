package practice;

import java.util.Scanner;

public class Quiz_1024_Practice {

	public static void main(String[] args) {

		quiz1();
		quiz2();
		quiz3();
				quiz4();
		//		quiz5();

	}

	public static void quiz1() {

		// 1~10까지 중에서 짝수만 출력해 주세요 (for,if)
		// 2 4 6 8 10

		for(int i=1;i<=10;i++) {
			if(i%2==0)
				System.out.print(i+" ");
		}
		System.out.println();
		System.out.println();


	}

	public static void quiz2() {

		// 1~100까지의 숫자 중 3의 배수의 합과 개수를 구하시오
		// 3의 배수의 합 = **
		// 3의 배수의 개수 = **개

		int sum=0,count=0;

		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				sum+=i;
				count++;

			}

		}

		System.out.println("3의 배수의 합 = "+sum+"\n3의 배수의 개수 = "+count);
		System.out.println();

	}

	public static void quiz3() {

		// 1~5까지의 팩토리얼 구하기
		// 1! = 1
		// 2! = 2
		// 3! = 6
		// 4! = 24
		// 5! = 120

		int fac=1;
		for(int i=1;i<=5;i++) {
			fac*=i;
			System.out.println(i+"! = "+fac);
		}


	}

	public static void quiz4() {

		// 숫자를 입력하다가 0을 입력하면 반복문을 빠져나온 후
		// 양수의 개수: 3개
		// 음수의 개수: 2개

		int pl =0,mi=0;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 입력");
		while(true) {
			int n = sc.nextInt();

			if(n==0)
				break;
			else if(n>0)
				pl++;
			else
				mi++;
//			else {
//				System.out.println("다시 입력");
//				continue;
//			}
		}
		System.out.println("양수의 개수: "+pl+"개");

		System.out.println("음수의 개수: "+mi+"개");
		sc.close();


	}

	public static void quiz5() {

		// 구구단을 세로로 출력하는데 2~9단까지의 반복이 3까지만 나오도록 해주세요
		// [2단]
		// 2x1=2
		// 2x2=4
		// 2x3=6
		//
		// [3단]
		// 3x1=3
		// 3x2=6
		// 3x3=9
		// .
		// .
		// [9단]



	}


}
