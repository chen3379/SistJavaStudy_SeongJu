package day1023;

public class CharAt_05 {

	public static void main(String[] args) {
		// 주민번호 ******-*******
		String num="001212-4222222";
		char seventh = num.charAt(7);
		
		if(seventh=='1')
			System.out.println("남자입니다");
		else if(seventh=='2')
			System.out.println("여자입니다");
		else if (seventh=='3')
			System.out.println("2000년 이후 남자입니다");
		else if (seventh=='4')
			System.out.println("2000년 이후 여자입니다");
		else
			System.out.println("잘못 기입하셨습니다(1~4까지만 입력 가능");
			
	}

}
