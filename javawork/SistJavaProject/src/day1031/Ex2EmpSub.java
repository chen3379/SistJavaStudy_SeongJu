package day1031;


public class Ex2EmpSub extends Ex2Emp{

	
	String dept; //부서
	
	//생성자 상속받은 후 dept 추가
	public Ex2EmpSub(String name, int sal,String d) {
		super(name, sal); //부모생성자 호출
		this.dept=d; //초기화
	}
	
	//메서드도 상속받아 dept 추가
	@Override
	public String getEmp() {
		return super.getEmp()+", "+dept;
	}
	
}
