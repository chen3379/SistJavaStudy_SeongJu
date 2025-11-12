package day1023;

import java.util.Scanner;

public class SwitchTest_03 {

	public static void main(String[] args) {


		// 학점을 switch

		Scanner sc=new Scanner(System.in);
		
		System.out.println("점수 입력");
		int score=sc.nextInt();
		char grade;

		switch(score/10) {
		case 10: case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';

		}
		
		System.out.println(score+" --> " +grade);

		sc.close();
	}

}
