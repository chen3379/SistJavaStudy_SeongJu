package day1031;

//super
public class Ex2Emp {

	String empName;
	int salary;
	
	//생성자
	public Ex2Emp(String name,int sal) {
		empName=name;
		salary=sal;
	}
	
	//출력메서드
	public String getEmp() {
		return empName+", "+salary;
	}
	
	//자식클래스에서 상속받은 내용을 다시 불러서 출력
	//getEmp()에는 출력하는 내용이 없기 때문에 출력문에 넣어야 출력 가능
	public static void main(String[] args) {
		//이효리,260000,개발팀
		//객체 생성은 자동으로 부모->자식순
		//그래야 자식이 부모의 멤버를 사용할 수 있기 때문
		//디폴트 생성자는 자동호출된다
		Ex2EmpSub emp=new Ex2EmpSub("이효리", 260000, "개발팀");
		System.out.println(emp.getEmp());
		
	}
}
