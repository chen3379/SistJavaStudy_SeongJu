package practice;

import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		// n! 구해보기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("!n을 구할 n을 입력");
			int n = sc.nextInt();
			int fac = 1;
			for(int i=1;i<=n;i++) {
				fac *= i;
			}
		System.out.println(n+"!= "+fac);	
				
		sc.close();
	}
	
	
}