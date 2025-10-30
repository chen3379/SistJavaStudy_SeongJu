package day1028;

public class Array2Cha_05 {

	public static void main(String[] args) {
		int [][] arr= {{15,43},{14,62,75},{24,53,38}};

		System.out.println("행의 개수: "+arr.length);
		System.out.println("0행의 열 개수: "+arr[0].length);
		System.out.println("1행의 열 개수: "+arr[1].length);
		System.out.println("2행의 열 개수: "+arr[2].length);
		
		// 출력
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("[%d][%d]= %d\n",i,j,arr[i][j]);
			}			
		}
		
		System.out.println("for~each로도 출력");
		
		for(int a[]:arr)
		{
			for(int num:a)
			{
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
		
		
	}
}
