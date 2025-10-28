package day1027;

public class ArrayRankTot_07 {

	public static void main(String[] args) {

		String stuName[]= {"김현능", "나지예","임소희","이태주"};
		int java[]= {88,77,100,89};
		int oracle[]= {78,96,55,99};
		int tot[]=new int[4];
		int rank[]=new int[4];
		double avg[]=new double[4];

		// 각 학생들 점수에 대한 총점 평균 등수 출력
		// 번호 학생명 자바 오라클 총점 평균 등수
		// 1   김현능 88  78   166 83  3

		for(int i=0;i<java.length;i++) {
			tot[i]=java[i]+oracle[i];
			avg[i]=(double)tot[i]/2;

		}

		for(int i=0;i<java.length;i++) {
			rank[i]=1;
			for(int j=0;j<java.length;j++) {
				if(avg[i]<avg[j])
					rank[i]++;
			}
		}



		System.out.println("번호\t학생명\t자바\t오라클\t총점\t평균\t등수");
		System.out.println("---------------------------------------------------");

		for(int i=0;i<java.length;i++) {

			System.out.println(i+1+"번\t"+stuName[i]+"\t"+java[i]+"점\t"+oracle[i]+"점\t"+tot[i]+"점\t"+avg[i]+"점\t"+rank[i]+"등");

		}

	}
}
