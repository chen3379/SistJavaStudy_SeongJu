package day1023;

import java.util.Scanner;

public class WhileTrue_12 {

	// class 안의 main 메서드
	public static void main(String[] args) {

		//test1();
		test2();
		
	}

	public static void test1() {

		// 점수 여러 개를 입력 후 합계를 구하는데
		// 1~100이 아닌 경우는 제외할 것
		// 0을 입력할 때까지 반복해서 점수를 입력한다

		Scanner sc=new Scanner(System.in);

		int score,sum=0;
		while(true) {	// while(true)인 경우 break 전까지 수행문 반복
			System.out.println("점수를 입력하시오");
			score=sc.nextInt();

			if(score==0)	// break 안주면 무한루프
				break;
			if(score<0||score>100)	// 1~100이 아닐 경우 다시 반복
				continue;
			sum+=score;

		}

		System.out.println("합계: "+sum);



	}
	
	public static void test2() {
		
		// 숫자 여러 개를 입력 후 합계를 구하는데
		// 1~100이 아닌 경우는 제외할 것
		// 0을 입력할 때까지 반복해서 점수를 입력한다
		// 입력된 개수와 평균까지 구해보기

		int sum=0,n=0; // n은 입력된 개수
		double avg;
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("숫자를 입력하세요 (종료: 0)");
			int score = sc.nextInt();
			
			if(score==0)
				break;
			
			if(score>100||score<0)
				continue;
			
			sum+=score;
			n++;
			
		}
		avg=(double)sum/n;
		System.out.printf("입력된 개수:%d\n합계:%d\n평균:%.2f",n,sum,avg);
		
	}



}
