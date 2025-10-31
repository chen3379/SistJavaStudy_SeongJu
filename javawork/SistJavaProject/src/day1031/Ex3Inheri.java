package day1031;

//super
class Person{

	String name;
	String dept;
	
	//메서드
	public void writeSawon() {
		System.out.println("부모변수출력");
		System.out.println("사원명: "+name+"\n부서명: "+dept);
	}
}

//sub
class MyInfo extends Person{
	
	int age;
	String position; //직급
	
	public MyInfo(String name,String dept,int age,String po) {
		this.name=name;
		this.dept=dept;
		this.age=age;
		this.position=po;
		
	}
	
	//단독으로 부모의 멤버로 메서드 작성 가능
	public void writeMyInfo() {
		System.out.println("사원명: "+this.name);
		System.out.println("부서명: "+this.dept);
		System.out.println("나이: "+this.age);
		System.out.println("직급: "+this.position);
		
	}
	
	//오버라이딩 메서드 구현(메서드명은 같아야 한다)
	@Override
	public void writeSawon() {
		super.writeSawon();
		System.out.println("자식변수출력");
		System.out.println("나이: "+this.age);
		System.out.println("직급: "+this.position);

	}
}





public class Ex3Inheri{

	public static void main(String[] args) {
		MyInfo in=new MyInfo("홍길동", "인사과", 31, "부장");
		in.writeMyInfo();
		System.out.println();
		in.writeSawon();
		
	}
}
