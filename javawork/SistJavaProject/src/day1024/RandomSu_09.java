package day1024;

import java.util.Random;
import java.util.Scanner;

public class RandomSu_09 {

	public static void main(String[] args) {

		// 1~100 사이의 난수를 발생시켜 그 숫자를 맞추기
		// 반복문을 발생시켜서 1~100까지의 난수를 변수 rnd에 저장

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int rnd=0,count=1;

		rnd = r.nextInt(100)+1;

		System.out.println("1~100중에 정답을 맞춰보세요");
		
		while(true) {
			System.out.print(count+"번째 시도: ");
			int a=sc.nextInt();
			count++;
			
			if(a==rnd) {
				System.out.println("\n정답!");
				break;
			}
			else if(a>rnd)
			System.out.println("\n땡! "+a+"보다 작습니다");

			else
			System.out.println("\n땡! "+a+"보다 큽니다");
		}
	}

}
