package day1023;

public class Continue_10 {

	public static void main(String[] args) {
		// continue: 자신이 포함된 반복문의 증감식으로 간다
		// continue 이후의 문장들은 수행되지 않는다
		
		// 1 2 4 5 7 8 10을 출력하려면
		
		for (int i = 1; i <=10; i++) {
			// 출력하지 않을 조건을 주어서 수행하지 않고 이동
			if(i%3==0)
				continue; // 수행문을 멈추고 증감식으로 이동
			System.out.print(i+" ");
			
			
		}
		
		System.out.println();
		
		for (int i = 1; i <=10; i++) {
			// 출력하지 않을 조건을 주어서 수행하지 않고 이동
			if(i%3==0)
				break; // for문 종료
			System.out.print(i+" ");
			
			
		}
		
		System.out.println();
		
		
//		홀수값:1
//		홀수값:3
//		홀수값:5
//		홀수값:7
//		홀수값:9
//		continue를 이용해서 출력해보세요 (1~10)
		
		for(int a=1;a<=10;a++) {
			if(a%2==0)
				continue;
			System.out.println("홀수값:"+a);
		}

	}

}
