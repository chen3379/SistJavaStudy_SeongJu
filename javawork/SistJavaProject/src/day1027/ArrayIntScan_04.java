package day1027;

import java.util.Scanner;

public class ArrayIntScan_04 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int a[]=new int[5];
		int sum=0;
		
		// 값 출력
		for(int i=0;i<a.length;i++) {
			System.out.print(i+1+"번지값: ");
			a[i]=sc.nextInt();
			sum+=a[i]; // 합계에 반복문만큼 누적
		}
		System.out.println("\n**입력한 값 출력**_(1:10)");
		
		// 출력
		for(int i=0;i<a.length;i++)
			System.out.println(i+1+":"+a[i]);
		System.out.println("합계: "+sum);
		
		sc.close();
	}
}
