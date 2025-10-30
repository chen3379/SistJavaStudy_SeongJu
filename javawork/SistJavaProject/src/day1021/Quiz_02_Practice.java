package day1021;

import java.util.Calendar;
import java.util.Scanner;

public class Quiz_02_Practice {

	public static void main(String[] args) {
		/*
		 당신의 이름은?
		 김효신
		 당신이 태어난 연도는?
		 1997
		 당신이 사는 지역은?
		 대전
		 ===================
		 [김효신님의 개인정보]
		 지역: 대전
		 나이: 28세
		 */
		
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		String name,city;
		int myYear,age;
		
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		System.out.println("당신이 태어난 연도는?");
		myYear=Integer.parseInt(sc.nextLine());
		System.out.println("당신이 사는 지역은?");
		city=sc.nextLine();
		
		System.out.println("=================");
		System.out.println("["+name+"님의 개인정보]");
		System.out.println("지역: "+city);
		
		age=cal.get(Calendar.YEAR)-myYear;
		System.out.println("나이: "+age+"세");
		

		sc.close();
	}

}
