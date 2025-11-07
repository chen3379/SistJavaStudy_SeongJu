package day1107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Ex2SetRandom {

	public static void main(String[] args) {
		// 1~45 사이의 랜덤수 6개 구해서 출력하기
		Random rd = new Random();
		HashSet<Integer> set1 = new HashSet<Integer>();
		while (true) {
			set1.add(rd.nextInt(45) + 1);
			
			if (set1.size() > 5)
				break;
		}
		System.out.println("랜덤 수 6개 생성");
		for (int i:set1)
			System.out.print(i + " ");

		System.out.println("\n오름차순 정렬 생성");
		Object[] ob=set1.toArray();
		Arrays.sort(ob);//오름차순 정렬
		for(int i=0;i<6;i++)
			System.out.print(ob[i]+" ");
	}

}
