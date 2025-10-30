package day1029;

class Member{
	// 모든 멤버 변수 private
	private String memName;
	private int memAge;
	private String job;
	
	
	static final String ADDR="세종시";
	
	// setter
	public void setMemName(String name) {
		memName=name;
	}
	public void setMemAge(int age) {
		memAge=age;
	}
	public void setJob(String job) {
		this.job=job;
	}
	
	// getter
	public String getMemName() {
		return memName;
	}
	public int getMemAge() {
		return memAge;
	}
	public String getJob() {
		return job;
	}
	
	// 출력메서드
	public void writeMember() {
		System.out.println("회원명: "+memName);
		System.out.println("회원나이: "+memAge);
		System.out.println("회원직업: "+job);
	}
}


public class Ex12Object {
	
	public static void main(String[] args) {
		
		Member mb=new Member();
		mb.setMemName("김성주");
		mb.setMemAge(25);
		mb.setJob("학생");
		
		System.out.println(Member.ADDR);
		mb.writeMember();
		System.out.println("==============");
		
		System.out.println(Member.ADDR);
		mb.setMemName("유재석");
		mb.setMemAge(25);
		mb.setJob("아나운서");
		
		mb.writeMember();
	
	}

}
