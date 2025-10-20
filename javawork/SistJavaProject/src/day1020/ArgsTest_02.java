package day1020;

public class ArgsTest_02 {

	public static void main(String[] args) {
		
		System.out.println("================================");
		System.out.println("\t매개변수 테스트_1");
		System.out.println("================================");
		System.out.println("첫번째 매개변수값: "+args[0]);
		System.out.println("두번째 매개변수값: "+args[1]);
		System.out.println("첫번째 두번째 연속값은 "+args[0]+args[1]+" 입니다");
		
		System.out.println("================================");
		System.out.println("\t매개변수 테스트_2");
		System.out.println("================================");
		//매개변수이용해서 
		//나의 이름은 홍길동 입니다
		//나의 나이는 23세 입니다
		System.out.println("나의 이름은 "+args[2]+"입니다");
		System.out.println("나의 나이는 "+args[3]+"세 입니다");
		
		
		
		
		

	}

}
