package day1031;

//super
class Shop{
	
	private String item;
	private int num;
	
	//디폴트생성자
	public Shop() {
		
		//초기값 지정도 가능
		item="딸기";
		num=10;
	}
	
	//명시적생성자
	public Shop(String item,int num) {
		this.item=item;
		this.num=num;
	}
	
	//메서드
	public void writeItem() {
		System.out.println("상품: "+item);
		System.out.println("수량: "+num);
	}
	
	
}

//sub_Shop을 상속: 디폴트생성자(초기값 1000원 주기)
class MyMall extends Shop{
	
	int price;
	
	//디폴트
	public MyMall() {
		price = 1000; //super 의 디폴트생성자는 super(); 생략 가능
	}
	
	//명시적
	public MyMall(String item,int num,int price) {
		super(item,num);
		this.price=price;
	}
	
	//writeItem 오버라이딩 후 가격도 추가
	@Override
	public void writeItem() {
		
		super.writeItem();
		System.out.println("가격: "+price);
		
	}		
	
}

public class Ex4Inheri {

	public static void main(String[] args) {
		
		//디폴트 생성자로 추가 후 메서드 출력
		MyMall d=new MyMall();
		d.writeItem();
		System.out.println();
		//명시적 생성자로 출력 오렌지 40 2000
		MyMall s=new MyMall("오렌지",40,2000);
		s.writeItem();
	}
}
