package day1030;

class MyShop{

	private String itemName;
	private int price;
	private String company;

	// 생성과 동시에 초기화
	public MyShop(String i,int p,String c) {
		this.itemName=i;
		this.price=p;
		this.company=c;
	}
	// 제목메서드
	public static void setTitle(){ // static <= 생성 안 받으려고
		System.out.println("상품명\t가격\t회사명");
		System.out.println("======================");

	}
	// 출력문
	public void getItem() {
		System.out.println(itemName+"\t"+price+"원\t"+company);

	}
}



public class Ex6ArrayObject {

	public static void main(String[] args) {

		// 4개를 생성 후 출력
		MyShop sh[]=new MyShop[4];

		sh[0]=new MyShop("아이폰", 1000, "애플");
		sh[1]=new MyShop("갤럭시", 2000, "삼성");
		sh[2]=new MyShop("샤오미폰", 100, "샤오미");
		sh[3]=new MyShop("lg폰", 500, "엘지");

		//제목출력
		MyShop.setTitle();

		//입력한 상품들 출력_foreach
		for(MyShop m:sh)
			m.getItem();

	}
}
