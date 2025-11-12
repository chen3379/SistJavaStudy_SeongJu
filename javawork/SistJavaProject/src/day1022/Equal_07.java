package day1022;

import java.util.Scanner;

public class Equal_07 {

	public static void main(String[] args) {
		// 문자열 비교는 관계연산자 사용 불가
		// equals라는 메소드를 사용해서 비교
		// 단어를 입력하면 해당 단어의 뜻을 출력한다
		
		Scanner sc = new Scanner(System.in);
		
		String word;
		
		System.out.println("영어 단어를 입력하시오");
		System.out.println("예: happy, rose, angel, phone");
		word = sc.nextLine();
		System.out.println("입력한 문자열: "+word);
		
		// 문자열 비교
		if(word.equals("happy")) // equals 는 대소문자 구분
			System.out.println("-> 행복하다");
		else if(word.equalsIgnoreCase("rose")) // equalsIgnoreCase 는 대소문자 구분X
			System.out.println("-> 장미");

		else if(word.equalsIgnoreCase("angel"))
			System.out.println("-> 천사");

		else if(word.equalsIgnoreCase("phone"))
			System.out.println("-> 전화기");
		else
			System.out.println("단어 목록에 없는 단어입니다");
		
		sc.close();
	}
}
