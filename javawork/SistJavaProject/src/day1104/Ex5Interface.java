package day1104;

//super_interface_상수와 추상메서드만 가능
interface FoodShop{
	String SHOPNAME="돼지국밥"; //final 이 생략된 것으로 상수이기 때문에 변경 불가
	public void order(); //abstract 생략
	public void delivery();
	
}

//sub
class Food implements FoodShop{
	@Override
	public void order() {
		System.out.println(SHOPNAME);
		System.out.println("음식을 주문합니다");
	}
	@Override
	public void delivery() {
		System.out.println(SHOPNAME);
		System.out.println("음식을 배달합니다");
	}
}


public class Ex5Interface {

	public static void main(String[] args) {
		Food food=new Food();
		food.order();
		food.delivery();
		//부모인터페이스로 선언 자식으로 생성 가능
		//인터페이스로 생성은 불가(추상클래스 생성 불가)
		FoodShop fd=new Food();
		fd.order();
		fd.delivery();
		
	}
}
