package day1023;

import java.util.Scanner;

public class IfSwitch_04 {

	public static void main(String[] args) {

		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력
		// if와 switch 2가지로

		Scanner sc=new Scanner(System.in);

		System.out.println("숫자 입력");
		int n=sc.nextInt();

		if(n%2==0) {
			System.out.println("[if문]");
			System.out.println("짝수");
		}
		else {
			System.out.println("[if문]");
			System.out.println("홀수");
		}

		switch(n%2) {
		case 1:
			System.out.println("[switch문]");
			System.out.println("홀수");
			break;
		default:
			System.out.println("[switch문]");
			System.out.println("짝수");
		}

		//12 개월 중 원하는 달을 입력하여 몇 일까지 있는지 출력

		// 1,3,5,7,8,10,12_31일


		System.out.println("월을 입력해주세요");
		int month=sc.nextInt();

		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31일까지 있습니다");
			break;
		case 2:
			System.out.println("28, 29일까지 있습니다");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일까지 있습니다");
			break;
		default:
			System.out.println("존재하지 않는 달입니다");
		}

	}

}
