package day1024;

public class GuguFor_04 {

	public static void main(String[] args) {

		// 구구단 각 단 가로 출력

		System.out.println("[구구단 가로ver]\n");
		for(int i=2;i<=9;i++) {
			System.out.print("["+i+"단]\t");
			for(int j=1;j<=9;j++) {

				// if(j==5) // x4 까지만 출력
				//	 break;

				System.out.print(i+"x"+j+"="+i*j+"\t");
			}
			System.out.println();
		}

		System.out.println();

		// 구구단 각 단 세로 출력

		System.out.println("[구구단 세로ver]\n");

		for(int i=2;i<=9;i++)
			System.out.print("["+i+"단]\t");
		System.out.println();
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {

				System.out.print(j+"x"+i+"="+j*i+"\t");
			}
			System.out.println();
		}

		System.out.println();
		
		// 자신이 속한 반복문 말고 최상단 반복문 빠져나가는것도 가능?
		// 이름 (라벨)을 주어서 빠져나가는 것 가능
		seong:for(int i=2;i<=9;i++) {
			System.out.print("["+i+"단]\t");
			for(int j=1;j<=9;j++) {

				if(j==5) // x4 까지만 출력
					break seong; // 2단의 x4 까지만 하고 전체 반복문 종료

				System.out.print(i+"x"+j+"="+i*j+"\t");
			}

		}
	}
}
