package spring.ex2.di;

public class Person {
	String schoolName;
	MyInfo info;
	
	//생성자
	public Person(MyInfo info) {
		this.info=info;
		
	}
	
	//세터주입
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	//출력 
	public void writeData() {
		
		System.out.println("학생정보 출력");
		System.out.println("학교명: "+schoolName);
		System.out.println("이름: "+info.name);
		System.out.println("나이: "+info.age);
		System.out.println("주소: "+info.addr);
	}
}
