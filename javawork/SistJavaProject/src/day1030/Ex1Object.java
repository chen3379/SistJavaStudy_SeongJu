package day1030;

class TestMethod{
	
	private String sangpum; // 상품명
	private String made; // 원산지명
	private int price;
	
	// 3개의 멤버변수를 한꺼번에 변경하는 생성자
	public TestMethod(String name,String made,int price) {
		
		sangpum=name;
		this.made=made;
		this.price=price;
	}
	
	public TestMethod() {
		
	}
	
	// 3개의 멤버변수를 한꺼번에 변경하는 메소드 _set
	
	// 출력용메서드
	
	public void setData(String name,String made,int price) {
		
		sangpum=name;
		this.made=made;
		this.price=price;
		
	}
	
	public String getData(){
		
		String s="상품명: "+sangpum+"\n원산지: "+made+"\n가격: "+price+"원\n============";
		
		return s;		
	}
	
	public void getInfo() {
		System.out.printf("상품명: %s\n원산지: %s\n가격: %d\n",sangpum,made,price);
		System.out.println("============");
	}
}

public class Ex1Object {

	public static void main(String[] args) {
		TestMethod tm1=new TestMethod();
		tm1.setData("텀블러", "중국", 5000);
		tm1.getInfo();
		
		TestMethod tm2=new TestMethod();
		tm2.setData("말차", "일본", 10000);
		tm2.getInfo();
		
		TestMethod tm3=new TestMethod();
		tm3.setData("바나나", "필리핀", 500);
		
		System.out.println(tm3.getData());
		
		tm3.getInfo();
		
		// 4번째 생성은 명시적생성자로
		
		TestMethod tm4=new TestMethod("파스타","이탈리아",4000);
		tm4.getInfo();
				
	}
}
