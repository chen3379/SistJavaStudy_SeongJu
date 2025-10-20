package day1020;

public class ParseInt_05 {

	public static void main(String[] args) {
		
		String su1="10";
		String su2="4";
		
		System.out.println("두수더하기: "+(su1+su2));
		
		//위의 su1,su2를 정수타입int num1,num2로 형변환후 두수를 더해보기
		int num1=Integer.parseInt(su1);
		int num2=Integer.parseInt(su2);
		
		System.out.println("형변환후 두수더하기: "+(num1+num2));
		System.out.println("형변환후 두수빼기: "+(num1-num2));
		System.out.println("형변환후 두수곱하기: "+(num1*num2));
		System.out.println("형변환후 두수나누기: "+(num1/num2));
		System.out.println("형변환후 두수나누어 나머지값: "+(num1%num2));
	
	}

}
