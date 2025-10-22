package day1021;

public class OperTest_10 {

	public static void main(String[] args) {
		// 증감연산자 ++, --
		
		int a,b;
		a=b=5;
		
		// 단항일 경우 앞에 붙히나 뒤에 붙히나 동일
		a++; // a = a + 1
		++b; // b = b + 1
		
		System.out.println("a:"+a+", b:"+b);
		
		// 수식에서 사용할 때는 전치, 후치 결과값이 틀리다
		int m,n;
		n=m=0;
		a=b=5;
		
		m=a++; // 후치일 경우는 먼저 대입 후 증가
		
		System.out.println("m:"+m+", a:"+a);
		
		n=++b; // 전치일 경우는 먼저 증가 후 대입
		
		System.out.println("n:"+n+", b:"+b);
		
		

	}

}
