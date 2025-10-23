package day1023;

import java.util.Scanner;

public class IfReview_01 {

	public static void main(String[] args) {
		// 이름과 자바 스프링 점수를 입력 후 총점을 구하시오
		// 총점이 180점 이상이면 "통과", 170점 이상이면 "좀 더 노력할 것", 170점 미만은 "재시험"
		// 조건은 if, 삼항연산자 아무거나 선택해서 할 것
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int java, spring;
		
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("자바 점수를 입력하세요");
		java=sc.nextInt();
		System.out.println("스프링 점수를 입력하세요");
		spring=sc.nextInt();
		int total=java+spring;
		
		
		if(total>=180)
			System.out.println("통과");
		else if(total>=170)
			System.out.println("좀 더 노력할 것");
		else
			System.out.println("재시험");
		
				

	}

}
