package day1029;

// 학교명: 쌍용고등학교
// 학생명: 김수현
// 학년: 2학년

public class Ex9Test {

	private String stuName; // 학생명
	private int grade; // 학년
	static String schoolName; // 학교명
	
	public void setStuName(String stuName) {
		this.stuName=stuName;
	}
	public String getStuName() {
		return stuName;
	}
	
	public void setGrade(int grade) {
		this.grade=grade;
	}
	public int getGrade() {
		return grade;
	}
	
	public static void main(String[] args) {
		Ex9Test ex9=new Ex9Test();
		Ex9Test.schoolName="쌍용고등학교";
		ex9.setStuName("김수현");
		ex9.setGrade(2);
		System.out.println("학교명: "+schoolName);
		System.out.println("학생명: "+ex9.getStuName());
		System.out.println("학년: "+ex9.grade);
	}
	
}
