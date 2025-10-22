package day1022;

import java.util.Scanner;

public class IfReturn_08 {

	public static void main(String[] args) {
		// 점수를 입력하는데 범위 1~100 만 입력하고 잘못 입력시 메서드 종료하게 . . .
		
		Scanner sc = new Scanner(System.in);
		int score;
		
		System.out.println("점수입력(1~100)");
		score = sc.nextInt();
		
		// 잘못 입력한 경우 종료
		if(score>100||score<1) {
			System.out.println("잘못 입력했습니다");
			return; // 현재 메인함수 종료
		}
		else
			System.out.println("점수: "+score);
			

	}

}
