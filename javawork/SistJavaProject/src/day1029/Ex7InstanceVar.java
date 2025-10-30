package day1029;

class MyInfo{	
	String name; //null
	String city; //null
	int age; //0
	
}

public class Ex7InstanceVar {

	public static void main(String[] args) {
		
		// MyInfo 생성해서 초기화 후 출력
		// 디폴트 인스턴스 변수는 생성 후 참조변수를 통해서 변수명을 불러올 수 있다
		// 참조변수명.변수명
		
		// Instance 변수가 private 이면 생성을 해도 변수에 그대로 접근 불가능
		// 반드시 메서드를 통해서 가져가야 한다
		MyInfo mi=new MyInfo();
		mi.name="홍길동";
		mi.city="서울시";
		mi.age=26;
		
		System.out.println("이름: "+mi.name);
		System.out.println("나이: "+mi.age);
		System.out.println("지역: "+mi.city);
		System.out.println();
	}
}
