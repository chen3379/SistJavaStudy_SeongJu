package day1023;

import java.util.Scanner;

public class StartsWith_13 {

	public static void main(String[] args) {

		// 반복해서 이름을 입력 후 김씨가 몇명인지...
		// 끝이라고 쓰면 프로그램 종료

		Scanner sc = new Scanner(System.in);

		int count=0;

		while(true) {
			
			System.out.println("이름을 입력하세요([끝]이라고 쓰면 종료)");
			String name = sc.nextLine();
			if(name.startsWith("김"))
				count++;
			if(name.equals("끝"))
				break;

				


		}
		System.out.println("김씨 성을 가진 사람은 총 "+count+"명 입니다");

	}

}
