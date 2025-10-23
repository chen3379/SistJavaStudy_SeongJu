package day1022;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		/*
		 오늘 입고된 상품명은?
		 갤럭시 폴드
		 입고된 수량은?
		 5
		 단가는?
		 1200000
		 
		 갤럭시 폴드 5개는 총 6000000원입니다
		 5개 이상은 10% DC됨
		 할인 후 총 금액: 5400000원		 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("오늘 입고된 상품명은?");
		String name = sc.nextLine();
		System.out.println("입고된 수량은?");
		int n = sc.nextInt();
		System.out.println("단가는?");
		int price = sc.nextInt();
		int total = n*price;
		int sale = (int)(total*0.9);
		
		System.out.println("\n"+name+" "+n+"개는 총 "+total+"원입니다");
		
		// if 문
		
		if(n>=5) {
			System.out.println("5개 이상은 10% DC됨");
			System.out.println("할인 후 총 금액: "+sale+"원");
		}
		else
			System.out.println("총 금액: "+total+"원");
		
		// 삼항 연산자
		
//		System.out.println(n>=5?"5개 이상은 10% DC됨\n할인 후 총 금액: "+sale+"원": "총 금액: "+total+"원");
		
	}

}
