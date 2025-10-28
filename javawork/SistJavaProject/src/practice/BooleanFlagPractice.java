package practice;

import java.util.Scanner;

public class BooleanFlagPractice {

	public static void main(String[] args) {
		// 숫자 배열을 생성과 동시에 초기화
		// 해당 숫자가 몇번째 있는지 출력, 숫자가 없으면 없다라고 출력
		// 찾는 숫자를 입력하여 해당 숫자의 유무, 순번 등을 출력. . . . . .
		int a[]= {35,12,63,124,54,73,29,41,15,76};

		Scanner sc=new Scanner(System.in);
		boolean flag=true;

		while(flag) {

			System.out.println("숫자를 입력하세요");
			int n = sc.nextInt();

			if(n==0) {
				System.out.println("프로그램 종료");
				flag=!flag;				
			}

			flag=!flag; // 찾아서 있으면 true 로 변경

			if(flag=!flag) {
				System.out.println("존재하지 않는 숫자입니다\n");
				continue;
			}
			
			for(int i=0;i<a.length;i++) {

				if(n==a[i]) {
					flag=true;
					System.out.println(i+1+"번째에서 검색됨\n");
				}

			}
			

		}
	}
}