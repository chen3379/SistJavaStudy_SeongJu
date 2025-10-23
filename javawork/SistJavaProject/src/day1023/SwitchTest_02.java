package day1023;

import java.util.Scanner;

public class SwitchTest_02 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int n=sc.nextInt();

		switch(n) {
		case 1:
			System.out.println("n is 1");
			break;
		case 2:
			System.out.println("n is 2");
			break;
		case 3:
			System.out.println("n is 3");
			break;
		default:
			System.out.println(n+" is not 1 2 3");
		}

	}

}
