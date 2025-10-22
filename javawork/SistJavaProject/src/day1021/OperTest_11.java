package day1021;

public class OperTest_11 {

	public static void main(String[] args) {
		
		// 대입연산자 +=, -=, *=, /=, %=
		
				int a,b,c,d,e;
				a=b=c=d=e=10;
				
				// a++;  1 증가
				a+=2; // a= a+2 a에 2를 더한 값이 다시 a
				b-=3;
				c*=3;
				d/=3;
				e%=3;
			
				System.out.println("a= "+a); // 12
				System.out.println("b= "+b); // 7
				System.out.println("c= "+c); // 30
				System.out.println("d= "+d); // 3
				System.out.println("e= "+e); // 1

				// !(not)
				boolean flag=false;
				
				System.out.println("flag= "+flag);
				System.out.println("flag= "+!flag);


	}
}
