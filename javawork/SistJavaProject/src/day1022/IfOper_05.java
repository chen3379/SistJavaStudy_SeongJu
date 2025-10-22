package day1022;

import java.util.Scanner;

public class IfOper_05 {

	public static void main(String[] args) {
		// 점수를 입력해서 학점을 알아보고 평가 구하기
		// 학점: if	평가: 삼항연산자(90점 이상: 장학생, 80점 이상: 우수, 80점 미만: 재수강)
		/*
		 점수를 입력하시오
		 78
		 학점: C학점
		 평가: 재수강
		 */
		
		char grade;
		String rate;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("점수를 입력하시오");
		
		int score=sc.nextInt();
		
		if(score>=90)
			grade='A';
		else if(score>=80)
			grade='B';
		else
			grade='C';
		
		System.out.println("학점: "+grade+"학점");
		
		rate = grade=='A'?"장학생":grade=='B'?"우수":"재수강";
		
		System.out.println("평가: "+rate);
		
	}

}
