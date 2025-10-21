package day1021;

public class ArgsQuiz_06 {

	public static void main(String[] a) {
		// 변수는 알아서 ..국어,영어,수학 점수를 매개변수로 입력 후
		// 총점과 평균을 구하시오
		// 단 평균은 소수점 2자리로 구할 것
		/*
		 홍길동 77 84 98
		 이름: ***
		 국어점수:**점
		 수학점수:**점
		 영어점수:**점
		 총점:**점
		 평균:**.**점
		 */
		
		String name = a[0];
		
		int korSC = Integer.parseInt(a[1]);
		int mathSC = Integer.parseInt(a[2]);
		int engSC = Integer.parseInt(a[3]);
		
		int totalSC = korSC+mathSC+engSC;
		double avgSC = totalSC/3.0;
		
		System.out.println("이름: "+name);
		System.out.println("국어점수: "+korSC+"점");
		System.out.println("수학점수: "+mathSC+"점");
		System.out.println("영어점수: "+engSC+"점");
		System.out.println("총점: "+totalSC+"점");
		System.out.printf("평균: %.2f점",avgSC);
		
		
	}

}
