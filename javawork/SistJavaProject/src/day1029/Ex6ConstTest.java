package day1029;

class Apple{
	
	public Apple() {
		System.out.println("Apple 클래스의 디폴트 생성자");
	}
}

class Banana{
	
	public Banana(String str) {
		System.out.println("Banana 클래스의 명시적 생성자: "+str);
	}
}

class Orange{
	
	// 생성자의 오버로딩_이름이 중복 가능(단 인자값은 중복되면 안된다)
	public Orange() {
		
		System.out.println("Orange 클래스의 디폴트 생성자");
	}
	public Orange(String str) {
		System.out.println("Orange 클래스의 문자열을 받는 생성자"+str);
	}
	public Orange(int num) {
		this();
		System.out.println("Orange 클래스의 숫자를 받는 생성자"+num);
	}
}

public class Ex6ConstTest {

	public static void main(String[] args) {
		// 생성자는 객체 생성시 자동 호출 되는 메소드
		// 일반메서드와 틀린게 리턴타입이 ㅇ벗다
		// 생성자는 주로 멤버의 초기화를 담당한다
		// 같은 생성자끼리 호출은 this()로 한다
		
		// Apple
		
		// Banana
		
		// Orange

		Orange or=new Orange(77); // 숫자를 받는 생성자 출력
		Orange or2=new Orange("안녕 생성자 공부중");
		Orange or3=new Orange(66);
		
	}
}
