package day1023;

public class ForWhile_07 {

	public static void main(String[] args) {
		
		// 1~10까지 반복 출력_for
		
		for(int i=1;i<11;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 1~10까지 반복 출력_while
		
		int j=1;
		
		while(j<=10) {
			System.out.print(j+" ");
			j++;
		}
		
		System.out.println();
		
		
		int w=1;
		
		while(w<=10) {
			System.out.printf("%d ", w++);
		}
		
		System.out.println();
		
		// for문으로 10~1
		
		for(int i=10;i>=1;i--) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// while(true)..반드시 break문으로 빠져나와야 한다
		
		int a=1;
		while(true) {
			System.out.printf("%4d",a++);
			
			if(a>10)
				break;
		}
		
		System.out.println();
		
		// for문으로 1,4,7,10
		
		for(int i=1;i<=10;i+=3) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 5,4,3,2,1 for
		
		for(int i=5;i>=1;i--) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 5,4,3,2,1 while
		
		int s=5;
		while(s>0) {
			System.out.printf("%d ",s--);
			
		}
		
		System.out.println();
		
		// Hello 를 가로방향으로 5번 출력하시오_for
		
		for(int i=1;i<=5;i++) {
			System.out.print("Hello ");
		}
	}

}
