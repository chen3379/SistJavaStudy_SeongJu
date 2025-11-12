package day1110;

//import day1110.OuterObj.InnerObj;

//내부클래스: 클래스 안에 존재하는 클래스
//특정클래스 내에서만 사용하는 클래스가 필요한 경우

class OuterObj {

	class InnerObj {

		public void write() {

			System.out.println("내부클래스의 메서드");

		}
	}

	public void show() {

		System.out.println("외부클래스의 메서드");
		System.out.println("외부에서 내부클래스의 메서드 호출 가능");
		
		//내부클래스의 메서드 호출
		InnerObj i=new InnerObj();
		i.write();
	}
}

public class Ex1InnerClass {

	public static void main(String[] args) {
		//외부클래스의 메서드 호출
		OuterObj o=new OuterObj();
		o.show();
		System.out.println("---------------------------------------");
		
		//내부클래스의 메서드를 메인에서 호출하려면 외부를 통해서만 가능
		//InnerObj i=new InnerObj();	오류 발생

		//1.OuterObj.InnerObj i=new OuterObj().new InnerObj();
		OuterObj.InnerObj i=o.new InnerObj();
		i.write();
	}

	class A {

	}
}
