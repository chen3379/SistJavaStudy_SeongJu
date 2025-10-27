package day1024;

import java.util.Scanner;

public class GuguScan_05 {
	
	public static void main(String[] args) {
		
		// 원하는 단을 입력해서 해당 단만 출력해보자
		/*
		 단을 입력하시오:
		 
		 [5단]
		 5x1=5
		 .
		 .
		 .
		 5x9=45
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("[0 입력 시 프로그램 종료]");
		
		while(true) {

			System.out.print("단을 입력하시오: ");
			int n = sc.nextInt();
			
			if(n==0) {
				System.out.println("\n프로그램이 종료되었습니다");
				break;
			}
			
			// 2~9단이 아니면 "2~9 사이의 숫자만 넣어주세요
			
			if(n<2||n>9) {
				System.out.println("\n!!!2~9 사이의 숫자만 입력하세요!!!\n");
				continue;
			}
			
			System.out.println("\n"+"["+n+"단]");
			for(int i=1;i<=9;i++) {
				System.out.println(n+"x"+i+"="+n*i);
			}
			System.out.println();
			
			
		}

	}
}
