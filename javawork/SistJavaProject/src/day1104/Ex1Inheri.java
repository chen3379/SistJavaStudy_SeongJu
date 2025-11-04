package day1104;

public class Ex1Inheri {
	
	public static void main(String[] args) {
		
		
		System.out.println("자식클래스로 생성");
		System.out.println("자식클래스로 선언, 자식 클래스로 생성");
		
		Ex1Red red;
		red=new Ex1Red();
		red.helloColor(); //부모메서드
		red.process(); //sub 클래스에서 만든 메서드

		Ex1Green green=new Ex1Green();
		green.helloColor();
		green.process();
		
		Ex1Blue blue=new Ex1Blue();
		blue.helloColor();
		blue.process();
	
		System.out.println("-------------------");
		System.out.println("부모클래스로 선언, 자식 클래스로 생성_다형성 polymorphism");
		
		Ex1Color color=new Ex1Red();
		color.helloColor(); //부모가 가진 메서드 호출 가능
		color.process(); //부모한테는 없고 자식만 가지고 있는 메서드는 호출 불가
		//메서드가 오버라이딩된 경우 호출 가능
		Ex1Color gr=new Ex1Green();
		gr.helloColor();
		gr.process();
		Ex1Color bl=new Ex1Blue();
		bl.helloColor();
		bl.process();
	}

}
