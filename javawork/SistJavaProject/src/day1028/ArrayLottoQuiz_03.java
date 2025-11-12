package day1028;

import java.util.Random;
import java.util.Scanner;

public class ArrayLottoQuiz_03 {

	public static void main(String[] args) {

		// 몇 장을 구입할지 입력 후 로또를 출력할 것!! - 중복체크, 오름차순
		// 몇 장 구입을 원하세요?
		// 2
		// 1회: 3 18 19 21 29 39
		// 2회: 5 28 29 31 39 41

		Scanner sc=new Scanner(System.in);
		Random r=new Random();

		int temp;
		
		
		System.out.println("몇 장을 구입을 원하세요?");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) { // 회차별 로또번호 생성
			
			System.out.print(i+"회: "); 
			int l[]=new int[6];
			
			for(int a=0;a<l.length;a++) { // 로또번호 6개 생성
				l[a]=r.nextInt(45)+1;
				for(int b=0;b<a;b++) { // 중복 제거
					if(l[a]==l[b]) {
						a--;
						break;
					}
				}
			}
			
			for(int a=0;a<l.length-1;a++) { // 로또번호 오름차순 정렬
				for(int b=a+1;b<l.length;b++)
					if(l[a]>l[b]) {
						temp=l[a];
						l[a]=l[b];
						l[b]=temp;
					}
				
			}

			for(int c:l)
				System.out.print(c+" ");
			System.out.println();
			
		}
		sc.close();
		
	}

}
