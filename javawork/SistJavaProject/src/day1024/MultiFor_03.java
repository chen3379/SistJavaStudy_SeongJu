package day1024;

public class MultiFor_03 {

	public static void main(String[] args) {

		System.out.println("**다중 for문 연습1**");

		for(int i=1;i<=3;i++) {

			for(int j=1;j<=5;j++) {
				System.out.println(i+" : "+j);

				if(j==3)
					break; // j는 3까지만 출력 후 현재 반복문 빠져나간다
			}

			System.out.println();

		}
		
		System.out.println("**다중 for문 연습2**");
		
		for(int i=1;i<=3;i++) {
			
			for(int j=1;j<=5;j++) {
				System.out.println(i+" : "+j);
			}
			
			System.out.println();
			if(i==2)
				break; // for의 i영역 i반복문 빠져나간다
		}

	}

}
