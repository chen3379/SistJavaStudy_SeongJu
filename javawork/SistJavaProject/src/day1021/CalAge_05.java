package day1021;

import java.util.Calendar;

public class CalAge_05 {

	public static void main(String[] args) {
		// 매개변수를 이용하여 이름과 태어난 연도를 입력 후 나이를 계산해보자
		
		// import
		Calendar cal = Calendar.getInstance();
		
		// 변수
		String name= args[0]; // 이름
		int myYear=Integer.parseInt(args[1]); // 태어난 연도 정수 변환
		// 계산(현재년도-본인생년)
		int curYear=cal.get(cal.YEAR); // 현재 연도
		
		int myAge=curYear-myYear;
		
		// 출력
		System.out.println("이름: "+name);
		System.out.println("나이: "+myAge);

		
	}

}
