package day1021;

public class DataType_01 {

	public static void main(String[] args) {
		// 기본적인 자료형..
		// 1. 논리형
		boolean flag=false; // true, false
							// boolean은 false가 기본값이지만 없다고 오류 날 수 있으니 지정

		// 2. 문자형
		char ch='가'; // 반드시 하나의 문자 2바이트, ' '로 표현
					 // 기본적으로 정수형, 아스키코드로 변경 가능
		
		// 3. 정수형
		byte a=-128;
		byte b=(byte)-129; // 1바이트 -128~127까지 가능
		   				   // 더 작은 자료형으로의 형변환(demotion) 값손실
						   // demotion으로 인해 127로 출력
		short c=3000;
		int d=233532543;
		long e=149241L; // L을 붙여야 long으로 인식, 아니면 기본형인 int로 봄
		
		// 4. 실수형
		double dou=425125.2541; // 기본
		float f=3.4125874f; // long과 동일하게 f를 붙여야 float으로 인식
		
		// 같은 크기일 경우 실수형이 정수형보다 큰 타입으로 처리된다
		
		// 출력
		System.out.println("flag="+flag);
		System.out.println("ch="+ch);
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
		System.out.println("dou="+dou);
		System.out.println("f="+f);
		
		// 소수점 자릿수까지 표기하고 싶을 때 printf
		System.out.printf("dou=%10.2f\n", dou); // 전체 자릿수는 10자리 소수점은 2자리 지정
		
		// dou 이용해서 소수점 1자리
		System.out.printf("dou=%10.1f\n", dou);
	}

}
