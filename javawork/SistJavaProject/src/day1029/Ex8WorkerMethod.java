package day1029;

class MyJb{
	
	private String name;
	private int age;
	private String city;
	
	// 변수 앞에 private을 붙이면 다른 클래스에서 생성을 하더라도 변수명에 접근할 수 없다
	// 반드시 메서드를 만들어서 그 메서드를 호출하여 사용
	// setter 메서드: 수정용 getter 메서드: 조회용 - 이 2개를 합쳐서 worker method라 부른다
	// 캡슐화(Encapsulation)
	
	// 수정용 메서드-set
	// 반환타입없다, 인자값 있음
	public void setName(String name) {
		this.name=name;
		
	}
	// 조회용 메서드-get
	// 무조건 반환타입 존재, 인자값 없음
	public String getName() {
		
		return this.name;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
}


public class Ex8WorkerMethod {
	
	public static void main(String[] args) {
		
		MyJb jb1=new MyJb();
		// wm1.name="Hong";
		
		jb1.setName("이수연");
		jb1.setCity("서울시");
		jb1.setAge(25);
		String name= jb1.getName();
		String city= jb1.getCity();
		int age= jb1.getAge();
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("지역: "+city);
	}

}
