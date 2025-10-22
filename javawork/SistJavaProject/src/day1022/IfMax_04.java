package day1022;

import java.util.Scanner;

public class IfMax_04 {

	public static void main(String[] args) {
		// 3개의 숫자를 입력하여 max, min 값을 구해보세요
		// if문 이용
		int max,min;

		Scanner sc=new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력하세요");
		int n1 = sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요");
		int n2 = sc.nextInt();
		System.out.println("세 번째 숫자를 입력하세요");
		int n3 = sc.nextInt();

		if(n1>n2&&n1>n3)
			max=n1;
		else if(n2>n1&&n2>n3)
			max=n2;
		else max =n3;

		if(n1<n2&&n1<n3)
			min=n1;
		else if(n2<n1&&n2<n3)
			min=n2;
		else min =n3;

		System.out.println("가장 큰 수는 "+max+"입니다\n가장 작은 수는 "+min+"입니다");

		System.out.println("**삼항연산자**");
		
		max=n1>n2&&n1>n3?n1:n2>n1&&n2>n3?n2:n3;
		System.out.println("가장 큰 수는 "+max+"입니다");

		min=n1<n2&&n1<n3?n1:n2<n1&&n2<n3?n2:n3;
		System.out.println("가장 작은 수는 "+min+"입니다");
	}

}
