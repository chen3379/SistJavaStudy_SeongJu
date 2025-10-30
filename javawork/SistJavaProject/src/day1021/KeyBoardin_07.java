package day1021;

import java.util.Scanner;

public class KeyBoardin_07 {

	public static void main(String[] args) {
		// Scanner는 문자열이나 숫자를 모두 키보드로 입력받으려 할 때 생성해준다
		Scanner sc = new Scanner(System.in); // sc라는 참조변수로 Scanner 클래스를 받아와서 입력
		
		String name, city;
		int age;
		
		
		System.out.println("이름을 입력해 보세요==>");
		name=sc.nextLine(); // 한 줄을 문자로 읽어온다( 공백 사용 가능)
		System.out.println("내 이름은 "+ name+"입니다");
		
		
		System.out.println("당신의 나이는?");
		age=Integer.parseInt(sc.nextLine()); // String ==> int
		System.out.println("내 나이는 "+ age+"세 입니다");

		// 숫자 입력 후 엔터를 누르면 그 엔터가 키보드버퍼로 저장되어 다음 문자열 읽을 때
		// 먼저 읽어버리는 현상 발생
		// 해결하려면 숫자를 문자처럼 변환해주면 가능하다
		System.out.println("당신이 사는 지역은?");
		city=sc.nextLine();
		System.out.println("내가 사는 지역은 "+ city+"입니다");
		
		sc.close();
	}

}
