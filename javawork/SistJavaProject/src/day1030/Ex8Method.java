package day1030;

public class Ex8Method {

	public static void nice(int age) {
		System.out.println("nice");
		System.out.println("안녕하세요");
		System.out.println("제 나이는 "+age+"세 입니다\n");
	}
	public static void main(String[] args) {
	
		System.out.println("프로그램 시작\n");
		nice(12);
		excellent(24.2);
		nice(22);
		good("김성주");
		perfect("야구",3);
	}
	
	public static void good(String name) {
		System.out.println("good");
		System.out.println("제 이름은 "+name+"입니다\n");
	}
	
	public static void excellent(double height) {
		System.out.println("excellent");
		System.out.println("제 키는 "+height+"m 입니다\n");
		
	}
	
	public static void perfect(String hobby,int n) {
		System.out.println("perfect");
		System.out.println("제 취미는 "+hobby+"입니다\n일주일에 "+n+"번 하고 있습니다\n");
		
	}
	
	
	
}
