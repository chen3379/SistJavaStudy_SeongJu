package day1029;

public class Ex2Card {

	static int width,height; // 카드의 너비, 높이
	String kind; // 카드의 무늬
	int number; // 카드의 숫자
	
	
	
	
	public static void main(String[] args) {
		width=10;
		height=20;
		System.out.println("카드의 높이: "+height+" 너비: "+width);
		System.out.println();
		Ex2Card c1=new Ex2Card();
		c1.kind="spade";
		c1.number=5;
		System.out.println("카드의 높이: "+height+" 너비: "+width+" 무늬: "+c1.kind+" 숫자: "+c1.number);
		
		Ex2Card c2=new Ex2Card();
		c2.kind="clover";
		c2.number=8;
		System.out.println("카드의 높이: "+height+" 너비: "+width+" 무늬: "+c2.kind+" 숫자: "+c2.number);
	}
}
