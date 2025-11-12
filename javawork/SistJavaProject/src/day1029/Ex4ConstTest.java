package day1029;

public class Ex4ConstTest { // 클래스 헤더

	// iv와 static변수 비교 테스트
	static int count=0; // 멤버 필드
	int count1=0;
	// 생성자
	public Ex4ConstTest() { // 생성자

		Ex4ConstTest.count++;
		count1++;
		System.out.println("static: "+count);
		System.out.println("instance: "+count1);

	}
	
	public static void main(String[] args) { // 메서드(동작) - 멤버 메서드
		
		Ex4ConstTest con=new Ex4ConstTest();
		Ex4ConstTest con2=new Ex4ConstTest();
		System.out.println(con.count);
		System.out.println(con2.count1);
		
		// 출력 static: 1 
		// instance: 1 
		// static: 2 -> static은 증가
		// instance: 1 -> instance는 증가X

		// iv는 서로 다른 메모리 할당, sv는 공유되는 메모리 할당
		// iv는 count 증가 X, sv는 count 증가(공유하기 때문)
		
	}
}
