package day1029;

public class Ex5ConstTest {

	int num; // 0
	
	// 디폴트 생성자
	public Ex5ConstTest() {
		
		num=10;
		System.out.println("나는 디폴트 생성자"+num);
		System.out.println();
	}

	// 명시적 생성자
	public Ex5ConstTest(int num) {
		
		this.num = num;
		System.out.println();
		System.out.println("나는 명시적 생성자");
	}
	
	// 메서드
	public int getNumber() {
		num=50;
		return num;
		
	}
	
	public static void main(String[] args) {
		
		Ex5ConstTest con=new Ex5ConstTest();
		System.out.println("##"+con.num);
		
		// 명시적생성자 생성
		Ex5ConstTest con2=new Ex5ConstTest(30); // 생성과 동시에 초기화
		System.out.println(con2.num);
		
		// 메서드
		Ex5ConstTest con3=new Ex5ConstTest();
		System.out.println(con3.getNumber());
		System.out.println(con2.getNumber());
	}
}
