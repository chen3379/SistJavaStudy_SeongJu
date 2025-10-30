package day1030;


class Student{
	
	private String name;
	private String hp;
	private int score;
	
	//명시적생성자_3개 변수 생성과 동시에 초기화
	public Student(String name,String hp,int score) {
		this.name=name;
		this.hp=hp;
		this.score=score;
	}
	//출력메서드
	public void getStudentScore() {
		System.out.println("이름: "+name);
		System.out.println("핸드폰: "+hp);
		System.out.println("점수: "+score);
		
	}
}

public class Ex5ArrayObject {

	public static void main(String[] args) {
		
		//배열로 생성해서 출력!!!
		
		//배열X
		Student stu1=new Student("홍길동", "010-1111-2222", 88);
		stu1.getStudentScore();
		Student stu2=new Student("이미영", "010-2222-3333", 99);
		stu2.getStudentScore();
		Student stu3=new Student("김구라", "010-3333-4444", 97);
		stu3.getStudentScore();
		
		System.out.println("안녕"+1);
		System.out.println("안녕"+2);
		System.out.println("안녕"+3);
		
		//배열
		//1.먼저 배열선언으로 개수를 할당받고 그 개수만큼 초기화
//		Student stu[]=new Student[3];
//		stu[0]=new Student("홍길동", "010-1111-2222", 88);
//		stu[1]=new Student("이미영", "010-2222-3333", 99);
//		stu[2]=new Student("김구라", "010-3333-4444", 97);
		
		//2.배열선언과 동시에 초기화
		Student stu[]= {
				new Student("홍길동", "010-1111-2222", 88),
				new Student("이미영", "010-2222-3333", 99),
				new Student("김구라", "010-3333-4444", 97)
		};		
		
		//반복문 출력
		System.out.println("**반복문으로 출력메서드 호출**");
		for(int i=0;i<stu.length;i++)
			stu[i].getStudentScore();
		
		//foreach
		System.out.println("**for~each문 출력**");
		for(Student s:stu) {
			s.getStudentScore();
		}
	}
}
