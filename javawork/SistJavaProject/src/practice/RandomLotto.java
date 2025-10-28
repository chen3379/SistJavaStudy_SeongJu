package practice;

import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {

		// 로또 번호 1~45까지 6개 생성(단, 중복X)
		
		Random rnd =new Random();
		int lotto[]=new int[6];
		int temp;

		
		for(int i=0;i<lotto.length;i++) { // 로또 번호 1~45까지 6개 생성
			lotto[i]=rnd.nextInt(45)+1;
			for(int j=0;j<i;j++) { // 중복 시 재생성
				if(lotto[i]==lotto[j]) { 
					i--;
					break;
				}
			}
		}

		for(int i=0;i<lotto.length-1;i++) { // 로또 번호 오름차순 정렬
			for(int j=i+1;j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}

		}
		
		System.out.print("로또 번호 추첨: ");
		for(int a:lotto)
			System.out.print(a+" ");
	}
}
