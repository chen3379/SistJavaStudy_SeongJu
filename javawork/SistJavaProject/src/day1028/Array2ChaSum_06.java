package day1028;

public class Array2ChaSum_06 {

	public static void main(String[] args) {
		String stuName[]= {"조성진","이태주","김민지"};
		int score[][]= {{88,77,99,0},{98,56,100,0},{55,88,99,0}};
	
		System.out.println("이름\t자바\t오라클\t스프링\t총점");
		for(int i=0;i<stuName.length;i++) {
			System.out.print(stuName[i]+"\t");
			for(int j=0;j<score[i].length-1;j++) {
				score[i][3]+=score[i][j];
				System.out.print(score[i][j]+"\t");
				}
			System.out.println(score[i][3]);
		}
	}
}
