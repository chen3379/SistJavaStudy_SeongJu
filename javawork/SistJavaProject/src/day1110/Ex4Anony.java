package day1110;

abstract class AstEx1{
	abstract public void display();
	abstract public void show();
}


public class Ex4Anony {

	//익명 내부클래스로 추상메서드 2개 오버라이딩
	
	AstEx1 as=new AstEx1() {
		
		@Override
		public void show() {
			System.out.println("show메서드 호출");
		}
		
		@Override
		public void display() {
			System.out.println("display메서드 호출");
		}
	};
	
	public static void main(String[] args) {
		Ex4Anony ex=new Ex4Anony();
		ex.as.show();
		ex.as.display();
	}
}
