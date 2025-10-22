package day1022;

import java.util.Scanner;

public class IfMax_03 {

	public static void main(String[] args) {
		// 2개의 숫자를 입력해서 max값 구하기
		// if문
		// 삼항연산자

		Scanner sc=new Scanner(System.in);

		int x,y,max;

		System.out.println("2개의 숫자를 입력해주세요");
		x=sc.nextInt();
		y=sc.nextInt();

		System.out.println("입력한 두 수는 "+x+","+y+"입니다");

		// if문

		if(x>y)
			max=x;
		else
			max=y;
		
		System.out.println("두 수 중에 더 큰 값은 "+max+"입니다");
		
		// 삼항연산자
		
		System.out.println("첫 번째 수가 더 "+(x>y?"크다":"작다"));
	}

}
