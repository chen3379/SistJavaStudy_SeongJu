package day1021;

import java.util.Scanner;

public class Scanner_08 {

	public static void main(String[] args) {
		// 이름과 국, 영, 수 점수를 입력 후 총점, 평균 출력해보기

		Scanner sc = new Scanner(System.in);

		String name=null;
		int kor=0, eng=0, math=0;

		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		System.out.println("이름: "+ name);

		System.out.println("당신의 국어, 영어, 수학 점수를 입력하세요");

		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		int totalScore = kor+eng+math;
		double avg = totalScore/3.0;

		System.out.println("국어, 영어, 수학 점수: "+ kor+"점, "+ eng+"점, "+ math+"점");
		System.out.println("====================================");
		System.out.println("총점: "+totalScore+"\n평균: "+avg);
	}

}
