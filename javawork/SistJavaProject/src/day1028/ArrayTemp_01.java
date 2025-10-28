package day1028;

import java.util.Arrays;

public class ArrayTemp_01 {

	public static void main(String[] args) {

		// 순서 바꾸기 1

		int x=10,y=20,temp1;
		temp1=x;
		x=y;
		y=temp1;
		System.out.println("x= "+x+", y= "+y);

		// 배열 순서 바꾸기

		int arrNums[]= {4,6,8};

		for(int a:arrNums) 
			System.out.print(a+" ");

		System.out.println("\n0번과 2번을 교환 후 출력");
		int temp2=arrNums[0];
		arrNums[0]=arrNums[2];
		arrNums[2]=temp2;
		for(int a:arrNums) 
			System.out.print(a+" ");
		System.out.println();


		int arr[]= {5,1,3,2,4};

		System.out.println("원데이터 출력");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println("\n거꾸로 출력 #1");


		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[arr.length-(i+1)]+" ");

		}

		System.out.println("\n거꾸로 출력 #2");
		for(int i=0;i<arr.length;i++) {
			int temp=arr[arr.length-(i+1)];
			System.out.print(temp+" ");
		}

		// 오름차순 정렬로직(가장작은 숫자를 앞으로 보내자_선택정렬)
		// 기준 데이터는 0번부터 끝에서 두번째까지
		System.out.println("\n오름차순 출력 #1");
		int temp3;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) { // 기준값이 비교값보다 클 때 순서를 변경하는게 오름차순
					temp3= arr[i];
					arr[i]=arr[j];
					arr[j]=temp3;
				}
			}
		}
		
		Arrays.sort(arr); //arr 정렬
		
		System.out.println();
		for(int a:arr) {
			System.out.print(a+" ");
		}
		

	}
}
