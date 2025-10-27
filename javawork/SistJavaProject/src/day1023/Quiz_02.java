package day1023;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {

		// quiz1();
		// quiz2();
		 quiz3();


	}

	public static void quiz1() {

		// 팩토리얼 구할 숫자를 입력
		// 5
		// 5! = 120

		Scanner sc=new Scanner(System.in);

		System.out.println("팩토리얼 구할 숫자를 입력하세요");
		int n=sc.nextInt();
		double fac=1;

		for(int a=1;a<=n;a++)
			fac*=a;

		System.out.println(n+"!= "+fac);
	}

	public static void quiz2() {

		// 1~100 중에서 5의 배수의 합을 구하시오
		// 1~100 중 5의 배수의 합은 ****입니다

		int sum = 0;

		for(int i=1;i<=100;i++) { // 1~100의 합 중 5의 배수인 경우만 합
			if(i%5==0)
				sum+=i;
		}
		System.out.println("1~100 중 5의 배수의 합은 "+sum+"입니다");
		
		int sum1 = 0;
		
		for(int i=5;i<=100;i+=5) { // 1~100까지 5의 배수만 합
			sum1+=i;
		}
		System.out.println("(2)1~100 중 5의 배수의 합은 "+sum1+"입니다");

	}

	public static void quiz3() {

		// 점수(1~100)을 입력받다가 0을 입력하면 반복문 빠져나온 후에
		// 총 갯수와 총점, 평균 출력하기
		// 78
		// 90
		// 120
		// 다시 입력해주세요
		// 88
		// 77
		// 0

		// 총 갯수:
		// 총점:
		// 평균: 소수점 1자리

		int count=0,sum=0;
		double avg=0;

		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요");

		while(true) {

			int score = sc.nextInt();
			if(score<0||score>100) {
				System.out.println("다시 입력해주세요");
				continue;
			}
			if(score==0) {
				System.out.println();
				break;
			}
			sum+=score;
			count++;

		}
		avg=(double)sum/count;

		System.out.println("총 갯수: "+count);
		System.out.println("총점: "+sum);
		System.out.printf("평균: %.1f",avg);

	}

}
