package day1031;

//super
class School{
	
	private String schoolAddr; //학교주소
	private int countStu; //학생수
	private int countTea; //교사수
	
	public static final String SCHOOLNAME="쌍용고등학교";
	
	
	//디폴트 생성자
	public School() {
		schoolAddr="강남구";
		countStu=200;
		countTea=15;
		
	}
	
	//명시적 생성자
	public School(String sc,int cs,int ct) {
		this.schoolAddr=sc;
		this.countStu=cs;
		this.countTea=ct;
	}
	
	//setter getter: 멤버 개별로 수정 또는 출력 가능
	public String getSchoolAddr() {
		return schoolAddr;
	}


	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}


	public int getCountStu() {
		return countStu;
	}


	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}


	public int getCountTea() {
		return countTea;
	}


	public void setCountTea(int countTea) {
		this.countTea = countTea;
	}
	
	public static String getSchoolname() {
		return SCHOOLNAME;
	}
	
	//출력메서드
	public void writeData() {
		System.out.println("학교주소: "+this.schoolAddr);
		System.out.println("학생 수: "+this.countStu);
		System.out.println("선생님 수: "+this.countTea);
	}

	
}

//sub_School을 상속받는다
class Student extends School{
	
	private String stuName; //학생명
	private int score; //점수
	
	//디폴트생성자_초기값 자유
	public Student() {
		stuName="아이유";
		score=90;
	}
	
	//명시적 생성자_Student의 멤버 stuName,score 을 추가한다	
	public Student(String sc,int cs,int ct,String name,int score) {
		super(sc,cs,ct);
		this.stuName=name;
		this.score=score;
	}	
	
	//setter getter 추가
	public String getStuName() {
		return stuName;
	}
	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
		
	
	//부모의 writeData 오버라이딩 해서 학생명과 점수 추가
	//맨 위에 학교명도 추가
	@Override
	public void writeData() {
		System.out.println("=====================");
		System.out.println("학교명: "+SCHOOLNAME);
		super.writeData();
		System.out.println("학생명: "+this.stuName);
		System.out.println("점수: "+this.score);
	}
}

public class Ex5Inheri {

	public static void main(String[] args) {
		
		//1.디폴트 생성자로 생성 후 메서드 호출
		Student d=new Student();
		d.writeData();
		
		//2.명시적 생성자로 생성 후 메서드 호출
		Student s=new Student("서울", 3, 5, "홍길동", 70);
		s.writeData();
		//3.1번째의 학생명과 점수만 변경 후 다시 출력
		//생성을 다시 하면 또 하나의 주소값이 생기므로 생성하지 않고 참조변수를 이용하여 변경
		d.setStuName("고윤정");
		d.setScore(94);
		d.writeData();

	}
}
