package day1029;

class StuInfo{

	private String stuName;
	private String major;
	private int grade;

	// 명시적 생성자

	public StuInfo(String sname,String mj, int grade) {
		stuName=sname;
		major=mj;
		this.grade=grade;
	}

	public String getStuName(){
		return stuName;
	}
	public String getMajor(){
		return major;
	}
	public int getGrade() {
		return grade;
	}

}




public class Ex10Const {

	public static void main(String[] args) {

		// 생성과 동시에 초기화 -> getter 메소드 불필요
		
		StuInfo stu1=new StuInfo("홍길동", "유아교육과", 2); 
		System.out.println(stu1.getStuName()+"님의 전공은 "+stu1.getMajor()+"이며 "+stu1.getGrade()+"학년입니다");
	}
}
