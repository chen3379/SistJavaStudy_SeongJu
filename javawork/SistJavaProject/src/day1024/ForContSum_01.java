package day1024;

import java.util.Scanner;

public class ForContSum_01 {

	public static void main(String[] args) {
		
		// 총 5개의 점수를 입력 받아 합계를 구하려고 한다(반복문)
		// 만약 1~100이 아니면 다시 입력하시오(continue)
		
		int sum=0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=5;i++) {
			System.out.print(i+"번 점수: ");
			int score =sc.nextInt();
			if(score<1||score>100) {
				System.out.println("다시 입력하시오");
				i--;
				continue;
			}			
			sum+=score;
			
		}
		
		System.out.println("총점: "+sum);
		
		
	}

}
