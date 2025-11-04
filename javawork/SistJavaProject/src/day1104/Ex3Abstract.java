package day1104;

//super
abstract class Fruit{
	
	//상수
	public static final String MESSAGE="오늘은 추상클래스 배우는 날!!";
	
	//일반메서드
	public void showTitle() {
		System.out.println("추상클래스 제목을 출력합니다");
	}
	
	//추상메서드_오버라이딩이 목적이므로 상속박은 자식 클래스에서는 반드시 오버라이딩 해주어야 한다
	public abstract void showMessage();
	
}

//sub1
class Apple extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Im Apple");
	}
}

//sub2
class Banana extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Im Banana");
	}
}

//sub3
class Orange extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Im Orange");
	}
}

public class Ex3Abstract {

	public static void main(String[] args) {
		//Polymorphism
		
		Fruit fruit;
		fruit=new Apple();
		fruit.showTitle();
		fruit.showMessage();
		fruit=new Banana();
		fruit.showMessage();
		fruit=new Orange();
		fruit.showMessage();
	}
	
}
