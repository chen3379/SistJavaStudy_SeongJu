package day1021;

import java.util.Scanner;

public class ScanTest_09 {

	public static void main(String[] args) {
		/*
		 이름 입력: ***(String)
		 점수: **(int)
		 학년: **(String)
		 [결과출력]
		 ***님은 *학년이며 평점은 **점 입니다
		 */
		
		Scanner sc = new Scanner(System.in); // import
		
		String name=null; // 변수 선언
		int score=0;
		String grade=null;
		
		System.out.print("이름 입력: "); // 입력
		name = sc.nextLine();
		
		System.out.print("점수: ");
		score = Integer.parseInt(sc.nextLine()); //Integer.parstInt("88") = 88
		
		System.out.print("학년: ");
		grade = sc.nextLine();
		
		System.out.println("\t[결과출력]"); // 출력
		System.out.println(name+"님은 "+grade+"학년이며 평점은 "+score+"점 입니다");
		

	}

}
