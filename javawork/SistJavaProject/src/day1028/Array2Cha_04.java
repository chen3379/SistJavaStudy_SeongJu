package day1028;

public class Array2Cha_04 {

	public static void main(String[] args) {

		// 2차원 배열: 행, 열

		int arr[][]= new int[2][3];
		arr[0][0]=10;
		arr[0][1]=20;
		arr[0][2]=30;
		arr[1][0]=40;
		arr[1][1]=50;
		arr[1][2]=60;

		System.out.println("행의 갯수: "+arr.length);
		System.out.println("0행의 열 갯수: "+arr[0].length);
		System.out.println("1행의 열 갯수: "+arr[1].length);
		System.out.println("===데이터 출력===");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		System.out.println("==============");
		System.out.println("2차원 배열의 초기값\n변경 후 다시 출력");
		System.out.println("==============");
		
		arr[0][1]=100;
		arr[1][0]=200;
		arr[1][2]=300;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
		System.out.println("==============");
		int arr1[][]= {{2,4},{3,5,6}};
		System.out.println(arr1.length);
		System.out.println(arr1[1][2]);
	}
}
