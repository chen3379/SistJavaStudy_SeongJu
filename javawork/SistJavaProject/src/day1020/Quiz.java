package day1020;

public class Quiz {

	public static void main(String[] args) {
		// args라는 매개변수 이용할것!!
		//변수는 마음대로 하되 이름에 걸맞게 만들것
		
		/*
		 오늘의 퀴즈
		 ==================
		 상품명: 아이폰17
		 수량: 2개
		 가격: 1500000원
		 총금액: 3000000원*/
		
		// 1.변수선언
		
		String name = args[0];
		int num = Integer.parseInt(args[1]);
		int price = Integer.parseInt(args[2]);
		
		// 2.계산
		
		int total_price = num*price;
		
		// 3.출력
		
		// 1)
		System.out.printf("상품명: %s\n수량: %d개\n가격: %d원\n총금액: %d원\n", name, num, price, total_price);

		// 2)
		System.out.printf("상품명: "+args[0]+"\n수량: "+args[1]+"개\n가격: "+args[2]+"원\n총금액: "+total_price+"원");
		
		// 3)
		System.out.println("\n상품명: "+args[0]);
		System.out.println("수량: "+args[1]+"개");
		System.out.println("가격: "+args[2]+"원");
		System.out.println("총금액: "+total_price+"원");
	}

}
