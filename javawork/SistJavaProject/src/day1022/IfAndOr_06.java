package day1022;

import java.util.Scanner;

public class IfAndOr_06 {

	public static void main(String[] args) {

		// 3과목 점수를 입력하여 총점, 평균 구하기
		// 각 과목은 모두 40점 이상이어야 하며 평균 180점 이상을 합격 기준으로 한다

		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("3과목 점수를 입력하세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int total = a+b+c;
		System.out.println("========================");
		System.out.println("성함: "+name);
		System.out.println("총점: "+total+"점");
		double avg = total/3.0;
		System.out.printf("평균: %.2f점\n",avg);
		System.out.println("========================");

		if(avg>=60&&a>=40&&b>=40&&c>=40)
			System.out.println(name+"님은 시험에 합격하셨습니다");
		else {
			System.out.println(name+"님은 시험에 불합격하셨습니다");
			if(avg>=60&&(a<40||b<40||c<40))
				System.out.println("과락인 과목이 있습니다");
			else if(avg<60&&a>40&&b>40&&c>40)
				System.out.println("평균이 60점 미만입니다");
			else {
				System.out.println("과락인 과목이 있습니다");
				System.out.println("평균이 60점 미만입니다");
			}
		}

	}

}
