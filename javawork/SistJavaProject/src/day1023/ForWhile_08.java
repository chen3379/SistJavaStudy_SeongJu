package day1023;

public class ForWhile_08 {

	public static void main(String[] args) {
		
		// 조건에 안 맞으면 1번도 반복 안 함
		
		for(int i=5;i<=1;i++) {
			System.out.println(i);
		}
		
		// for문 밖에서 i값을 출력하고 싶을 때
		
		int i=10;
		
		for(;i<=50;i+=5) { // 초기식을 전에 지정하더라고 ;은 앞에 붙여야 한다
			System.out.println(i);
		}
		System.out.println("\n빠져나온 후의 i값: "+i);
		
		// 1~10까지 짝수만 출력하기
		for(int n=1;n<=10;n++) {
			if(n%2==0)
			System.out.print(n+" ");
		}
		
		System.out.println();

		// 1~10 뒤에 Hello 붙여서 출력
		
		for(int x=1;x<=10;x++) {
			System.out.print(x+" Hello ");
		}
		System.out.println("\nfor문을 빠져나와 종료");
		
	}

}
