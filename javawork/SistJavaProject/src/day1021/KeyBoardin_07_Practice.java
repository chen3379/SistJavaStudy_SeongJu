package day1021;

import java.util.Scanner;

public class KeyBoardin_07_Practice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name, city;
		int age;
		
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		System.out.println("내 이름은 "+name+"입니다");
		
		System.out.println("당신의 나이는?");
		age=Integer.parseInt(sc.nextLine());
		System.out.println("내 나이는 "+age+"세 입니다");
		
		System.out.println("당신이 사는 지역은?");
		city=sc.nextLine();
		System.out.println("내가 사는 지역은 "+city+"입니다");

		sc.close();
	}

}
