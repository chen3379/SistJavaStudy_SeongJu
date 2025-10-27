package day1024;

public class MultiFor_02 {
	
	public static void main(String[] args) {
		
		// i가 1일 때 j가 4번 반복
		// i가 2일 때 j가 4번 반복
		// i가 3일 때 j가 4번 반복 . . . .이렇게 for문이 이중으로 반복되는 구조를 다중 for문
		
		for(int i=1;i<=3;i++) {
			System.out.println(i+": Happy");
			for(int j=1;j<=4;j++)
				System.out.println("\t"+j+":Friday");
			
			System.out.println();
		}
		
	}

}
