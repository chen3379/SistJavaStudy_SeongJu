package day1021;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// Q. 2개의 숫자를 입력하여 + - * / %을 구해봅시다
		/*
		 첫번째 숫자는? 7
		 두번째 숫자는? 3
		 
		 =================
		 	[결과출력]
		 두 수의 합은 10 입니다
		 두 수의 차이는 4 입니다
		 두 수의 곱은 21 입니다
		 두 수를 나누면 2 입니다
		 두 수를 나누면 나머지는 1 입니다
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n1,n2;
		
		System.out.print("첫번째 숫자는? ");
		n1 = sc.nextInt();
		System.out.print("두번째 숫자는? ");
		n2 = sc.nextInt();
		
		System.out.println("==========================");
		System.out.println("\t[결과출력]");
		System.out.println("두 수의 합은 "+(n1+n2)+" 입니다");
		System.out.println("두 수의 차이는 "+(n1-n2)+" 입니다");		
		System.out.println("두 수의 곱은 "+(n1*n2)+" 입니다");
		System.out.println("두 수를 나누면 "+(n1/n2)+" 입니다");
		System.out.println("두 수를 나누면 나머지는 "+(n1%n2)+" 입니다");
		

	}

}
