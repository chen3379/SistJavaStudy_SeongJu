package day1029;

// 객체의 속성은 인스턴스변수로 표현하고 객체의 동작은 메서드로 표현한다
// Object: 객체(핸드폰,텀블러,마우스)
// Class: 객체를 정의해놓은 것, 객체를 생성하기 위해 존재
// Instance: 클래스에서 만들어진 객체가 그 클래스의 인스턴스

// 멤버변수 : instance 변수&static 변수(클래스변수)

public class Ex1Object {
	
	String name; // iv 객체 생성 후 값 변경, 호출 가능
	static final String MESSAGE="오늘은 클래스 배우는 날";
	// cv - 주로 상수 선언_객체 생성없이 클래스명으로 접근 가능(같은 클래스내에서는 클래스명 생략 가능)
	
	static int num;

	public static void main(String[] args) {
		
		System.out.println("static변수는 new로 생성 없이 호출 가능하다\n"+MESSAGE);
		System.out.println(Ex1Object.MESSAGE);
		
		// MESSAGE="nice"; final이라서 값 변경 불가
		
		// name과 같은 인스턴스 변수는 객체 생성을 해야만 사용 가능
		Ex1Object ex1=new Ex1Object(); // ex1을 인스턴스 변수라고 한다
		System.out.println(ex1.name); // 클래스에서 초기화 안하면 문자는 null로 자동 인식
		
		// name 초기화
		ex1.name="as";
		System.out.println(ex1.name);
		
		// name 2번째 초기화 후 출력
		Ex1Object ex2=new Ex1Object();
		ex2.name="qwe";
		System.out.println(ex2.name);
		
		System.out.println("다 같이 사용하는 메세지: "+MESSAGE);
	}

}
