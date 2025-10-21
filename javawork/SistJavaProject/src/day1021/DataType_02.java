package day1021;

public class DataType_02 {

	public static void main(String[] args) {
		// 강제 형변환(cast연산자)
		
		int x=7,y=4;
		
		System.out.println(x/y); // 1 : 정수형끼리의 계산결과는 무조건 정수 int
		System.out.println((double)x/y); // 계산시 x를 double로 변환해서 계산: 결과는 double
		System.out.println(x/(double)y); // 수식 중에 1개라도 double이 있을 경우: 결과는 double
		
		double d=100.0;
		int i = 100;
		int result=(int)d+i; // 직접 형 변환 명시 필요
		double result2=d+i;
		
		System.out.println("result= "+result);
		System.out.println("result2= "+result2);

	}

}
