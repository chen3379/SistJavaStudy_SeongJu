package day1020;

public class VarTest_04 {

	public static void main(String[] args) {
		// 변수: 메모리 공간에 할당 ,접근
		//할당된 메모리에 접근을 하려면 이름(변수)
		//선언: 컴파일러에게 무언가를 알리는 행위
		
		int num; //10진수 정수의 저장을 위한 메모리공간을 할당하겠다 그이름이 num
		num=10; //num에 10을 대입해 주겠다
		
		int num2=100;
		int sum=num+num2;
		System.out.println(num+"+"+num2+"="+sum);
		
		String su1="20";
		String su2="30";
		
		System.out.println(su1+"+"+su2+"="+(su1+su2));
		
		//String 타입을 int타입으로 변경하려면 형변환이 필요하다
		int s1=Integer.parseInt(su1);  //문자열 20이 정수20 으로 변환
		int s2=Integer.parseInt(su2); 
		  
		
		//출력시에는 가급적 변수를 이용하여 가장 간단히 출력하기를 권장
		System.out.println(Integer.parseInt(su1)+Integer.parseInt(su2));
		System.out.println(s1+s2);

	}

}
