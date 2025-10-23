package day1023;

import java.util.Scanner;

public class ForQuiz_01 {

	public static void main(String[] args) {

		// 1) 1~20까지를 출력
		// 5의 배수는 제외 후 출력

//		for(int i=1;i<=20;i++) {
//			if(i%5==0)
//				continue;
//			System.out.print(i+" ");
//		}
//
//		System.out.println();
//
		// 2)1~50까지 출력하는데 3씩 증가하게 출력(1 4 7 10...)
//
//		for(int j=1;j<=50;j++) {
//			if(j%3!=1)
//				continue;
//			System.out.print(j+" ");
//		}
		
		// 3) 내가 숫자를 입력하면 1부터 입력한 숫자까지의 합계를 구해서 출력해보자
		// 합계를 구할 숫자는? 5
		// 1부터 5까지의 합은 15
		
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.print("합계를 구할 숫자는? ");
//		int n = sc.nextInt();
//		int sum=0;
//		for(int i=1;i<=n;i++)
//			sum+=i;
//		System.out.println("1부터 "+n+"까지의 합: "+sum);
		
		// 4)1~100까지의 숫자 중에서 짝수의 합과 홀수의 합을 나누어 출력
		// 짝수(even)의 합:***
		// 홀수(odd)의 합:***

		int oddSum=0;
		int evenSum=0;
		
		for(int i=1;i<=100;i++) {
			if(i%2==0)
				evenSum+=i;
			else
				oddSum+=i;
				
		}
		
		System.out.println("짝수(even)의 합: "+evenSum);
		System.out.println("홀수(odd)의 합: "+oddSum);
		
	}

}
