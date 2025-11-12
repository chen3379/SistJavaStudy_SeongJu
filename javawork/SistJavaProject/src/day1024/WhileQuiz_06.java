package day1024;

import java.util.Scanner;

public class WhileQuiz_06 {

	public static void main(String[] args) {
		
		// 점수를 입력하다가 Q or q를 입력하면 while문을 빠져나온 후
		// 총 개수, 총점, 평균 구해서 출력하시오
		
		Scanner sc= new Scanner(System.in);
		String score;
		int sum=0,count=0;
		
		System.out.println("[Q 입력시 프로그램 종료]");
		double avg;
		while(true) {
			System.out.println("점수를 입력하세요");
			score= sc.nextLine();
			if(score.equalsIgnoreCase("Q"))
				break;
			sum+=Integer.parseInt(score);
			count++;
		
		}
		
		// 평균은 총점을 갯수로 한번만 나누면 되므로 반복문 밖에서 계산한다
		
		avg= (double)sum/count;	// 둘 다 정수형이므로 정확히 실수로 나오게 하려면 double 사용
		
		System.out.printf("\n=============\n총 개수: %d\n총점: %d\n평균: %.2f",count,sum,avg);
		
		sc.close();
	}
}
