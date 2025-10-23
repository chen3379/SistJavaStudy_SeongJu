package day1023;

import java.util.Scanner;

public class ForSum_09 {

	public static void main(String[] args) {


		// 1~10까지의 합

		int sum=0;
		int j=1;

		for(;j<=10;j++)
			sum+=j;

		System.out.println("합계: "+sum);

		// 1~10까지의 평균

		double avg=(double)sum/(j-1);

		System.out.println("1부터 10까지의 평균: "+avg);

		// 1~10까지의 합_while

		int i=1,sum2=0;

		while(i<=10) {
			sum2+=i++;
		}
		
		System.out.println("합계(while): "+sum2);
		
		
		// 1~10까지 2씩 증가하며 더해보자
		
		int sum3=0;
		
		for(i=1;i<=10;i+=2)
			sum3+=i;
		
		System.out.println("1~10까지 2씩 증가한 합계: "+sum3);

		
		// n! 구하기
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("계산을 할 숫자를 입력하세요");
		int n=sc.nextInt();
		double fac=1;
		
		for(int a=1;a<=n;a++)
			fac*=a;
		
		System.out.println(n+"!= "+fac);
		
		
			
			
	}

}
