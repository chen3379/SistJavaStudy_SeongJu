package day1028;

import java.util.Random;
import java.util.Scanner;

public class BingoGame_07 {

	public static void main(String[] args) {
		// 3행 3열의 테이블 안에 1~3까지의 랜덤 수를 발생시켜서 빙고게임 진행
		// 8개의 빙고가 나오면 최고 확률

		Scanner sc=new Scanner(System.in);
		int puzzle[][]=new int[5][5];
		Random r=new Random();
		int count=0;
		// 3행 3열 안에 1~3까지의 난수 발생시킨다

		System.out.println("Bingo Game: 같은 숫자가 한 줄로 가로,세로,대각선 어디라도 나오면 빙고\n");


		while(true) {		

			int bingo=0;
			count++;

			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) 
					puzzle[i][j]=r.nextInt(5)+1;

			}

			for(int i=0;i<puzzle.length;i++) {
				for(int j=0;j<puzzle[i].length;j++) 
					System.out.printf("%4d",puzzle[i][j]);
				System.out.println();
			}

			// 빙고의 조건
			// 가로
			for(int i=0;i<puzzle.length;i++) {
				if(puzzle[i][0]==puzzle[i][1]&&puzzle[i][1]==puzzle[i][2]&&
						puzzle[i][2]==puzzle[i][3]&&puzzle[i][3]==puzzle[i][4])
					bingo++;
			}

			// 세로
			for(int i=0;i<puzzle.length;i++) {
				if(puzzle[0][i]==puzzle[1][i]&&puzzle[1][i]==puzzle[2][i]&&
						puzzle[2][i]==puzzle[3][i]&&puzzle[3][i]==puzzle[4][i])
					bingo++;
			}

			int i=0;
			
			// 대각선\			
			if(puzzle[i][i]==puzzle[i+1][i+1]&&puzzle[i+1][i+1]==puzzle[i+2][i+2]&&
					puzzle[i+2][i+2]==puzzle[i+3][i+3]&&puzzle[i+3][i+3]==puzzle[i+4][i+4])
				bingo++;
			// 대각선/
			if(puzzle[i+4][i]==puzzle[i+3][i+1]&&puzzle[i+3][i+1]==puzzle[i+2][i+2]&&
					puzzle[i+2][i+2]==puzzle[i+1][i+3]&&puzzle[i+1][i+3]==puzzle[i][i+4])
				bingo++;
			
			System.out.println("\n빙고 개수: "+bingo+"개\n");
			if(bingo==0) {
				continue;
				
			}
			System.out.println(count+"번째 빙고");

			System.out.println("\nPress Enter to start new Bingo(Exit:Q)");
			String n=sc.nextLine();
			if(n.equalsIgnoreCase("q"))
				break;
		}

		sc.close();
	}
}
