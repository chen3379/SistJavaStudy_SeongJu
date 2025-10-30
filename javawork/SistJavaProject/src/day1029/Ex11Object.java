package day1029;

public class Ex11Object {

	private String sangpum;
	int su;
	int price;
	static final String SHOPNAME="이마트";
	
	public static void main(String[] args) {
		
		Ex11Object ob=new Ex11Object();
		ob.sangpum="딸기";
		ob.su=10;
		ob.price=25000;
		
		System.out.printf("상점명: %s \n상품명: %s\n가격: %d원\n수량: %d개",
				SHOPNAME,ob.sangpum,ob.price,ob.su);
		
	}
}
