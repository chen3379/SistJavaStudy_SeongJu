package day1027;

import java.util.Scanner;

public class ArrayScanTotAvg_06 {

	public static void main(String[] args) {
		// 인원수를 먼저 입력 후 그 인원수만큼 이름과 점수를 입력 후 총점, 평균 구하기

		Scanner sc=new Scanner(System.in);
		int n;
		String name[];
		int score[];
		int rank[];
		
		int tot=0;
		double avg=0;

		System.out.print("학생 수를 입력하세요 ");
		n=Integer.parseInt(sc.nextLine());
		name=new String[n];
		score=new int[n];
		rank=new int[n];

		for(int i=0;i<name.length;i++) {
			System.out.print(i+1+"번째 학생 이름 입력: ");
			name[i]=sc.nextLine();
			System.out.print("========>점수 입력: ");
			score[i]=Integer.parseInt(sc.nextLine());
			tot+=score[i];
			
		}
		avg=(double)tot/n;
		
		// 등수 구하기(다중 for문)
		for(int i=0;i<n;i++) {
			rank[i]=1;
			for(int j=0;j<n;j++) {
				if(score[i]<score[j])
					rank[i]++;
				
			}
					
		}

		System.out.println("--------------------");
		System.out.println("번호\t학생명\t점수\t등수");
		System.out.println("--------------------");
		for(int i=0;i<n;i++)
			System.out.println(i+1+"번\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		System.out.println("--------------------");
		System.out.println("총점: "+tot+"점");
		System.out.println("평균: "+avg+"점");


		sc.close();
	}
}
