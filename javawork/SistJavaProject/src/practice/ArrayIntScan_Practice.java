package practice;

import java.util.Scanner;

public class ArrayIntScan_Practice {

	public static void main(String[] args) {
		
		// 배열을 생성하고 값을 입력해서 지정해주기
		
		
		int a[]=new int[7]; // 길이가 7인 배열 a 생성
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<a.length;i++) { // a 길이까지 반복
			System.out.print(i+1+"번째 인덱스 값 입력: ");
			a[i]=sc.nextInt(); // i번째 인덱스에 값 입력해서 지정			
		}
		System.out.println("\n===인덱스값 출력===");
		for(int i=0;i<a.length;i++)
			System.out.println(1+i+"번째 인덱스 값: "+a[i]);
		
	}
}
