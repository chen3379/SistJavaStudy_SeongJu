package day1027;

public class ArrayInt_02 {
	
	public static void main(String[] args) {
		
		// 배열 선언
		// 기본형 배열은 객체로 인식
		
		int[]arr1,arr2; // 배열 선언
		arr1=new int[3]; // 배열 생성... 메모리 할당
		arr2=new int[4]; // 할당만 해도 값은 0으로 초기화
		int[] arr3=new int[5];

		// arr1: 할당만 하고 초기값 지정 없이 출력 가능
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
		
		System.out.println();
		
		// arr2 초기화
		arr2[0]=10;
		arr2[1]=20;
		arr2[3]=40;
//		arr2[2]=30;

		// arr2 출력 (초기화 안한 인덱스만 0으로 출력)
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+" ");
		System.out.println();
		// for+each문..i값 없이 모든 값을 일괄적으로 출력하고 싶다면 for_each도 자주 사용
		for(int a1:arr1) // for(자료명 참조변수명:배열명)
			System.out.print(a1+" ");
		System.out.println();
		// arr2도 foreach
		for(int a2:arr2)
			System.out.print(a2+" ");
		
		System.out.println("정수형 배열변수를 선언과 동시에 저장한다");
		int a3[]= {5,7,9,100,45,32,77};
		
		System.out.println("출력#1 _ 0==> 5");
		for(int i=0;i<a3.length;i++)
			System.out.println(i+"==> "+a3[i]);
		
		System.out.println();
		
		System.out.println("출력#2 a3의 모든값을 가로로 출력");
		for(int a:a3)
			System.out.print(a+" ");
			
		

	
	}

}
