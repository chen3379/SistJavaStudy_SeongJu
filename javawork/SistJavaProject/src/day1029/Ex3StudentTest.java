package day1029;

public class Ex3StudentTest {
	
	public static void main(String[] args) {
		
		Ex3Student.schoolName="쌍용교육센터";
		Ex3Student.schoolClass=4;

		Ex3Student stu1=new Ex3Student();
		stu1.name="김성주";
		stu1.age=26;
		
		Ex3Student stu2=new Ex3Student();
		stu2.name="김성재";
		stu2.age=21;
		
		System.out.println("학생1 정보:"+Ex3Student.schoolName+","+Ex3Student.schoolClass+","+stu1.name+","+stu1.age);
		System.out.println("학생2 정보:"+Ex3Student.schoolName+","+Ex3Student.schoolClass+","+stu2.name+","+stu2.age);
	}

}
