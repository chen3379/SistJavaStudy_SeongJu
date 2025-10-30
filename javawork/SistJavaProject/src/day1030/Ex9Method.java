package day1030;

public class Ex9Method {

	public static void main(String[] args) {
		System.out.println("두 수의 합: "+add(3, 5));
		System.out.println("두 수의 제곱: "+square(4.1));
		System.out.println("정수+실수: "+sum(3, 2.5));
		System.out.println("실수+정수: "+sum(3.2, 5));
	}
	
	public static int add(int num1,int num2) {
		return num1+num2;
	}
	
	public static double square(double num) {
		return num*num;
	}
	
	public static double sum(int n1,double n2) {
		return n1+n2;
	}
	
	public static double sum(double n1,int n2) { //sum 메서드명이 중복돼도 인자를 다르게 하면 사용 가능
		return n1+n2;		
	}
}
