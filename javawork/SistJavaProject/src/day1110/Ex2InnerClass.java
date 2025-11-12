package day1110;

class Outer{
	
	String name="홍길동";
	int age=22;
	
	//내부클래스: 외부클래스의 멤버변수사용이 가능하다
	class Inner1{
		
		public void show() {
			
			System.out.println("***Inner1의 내부클래스***");
			System.out.println("이름: "+name+", 나이: "+age);
		}
		
	}
	//외부클래스의 메서드
	public void write() {
		//외부에서 내부클래스 메서드 호출
		Inner1 in1=new Inner1();
		in1.show();
	}
	
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		
		//1.외부클래스의 write메서드 호출
		Outer o=new Outer();
		o.write();
		System.out.println("--------------------------");
		//2.메인에서 곧장 내부클래스의 show메서드 호출
		Outer.Inner1 oi1 =o.new Inner1();
		oi1.show();
	}
}
