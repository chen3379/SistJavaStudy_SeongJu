package day1029;

// **학생1정보**
// 이름: 이병헌
// 소속반:JAVA 4class
// 성별: 남자
// 주소: 서울시 강서구
// =================
// **학생2정보**
// 이름: 신민아
// 소속반:JAVA 4class
// 성별: 여자
// 주소: 서울시 강동구

class Quiz{
	
	private String stuName;
	private String gender;
	private String addr;
	
	static String ban;
	static int cnt=0;
	
	private int stuNum;
	
	// 어떤 방법으로 해도 좋다
	// 디폴트 생성자_setter, getter
	// 명시적 생성자에 3개의 인자를 넣고 해도 좋다
	// 출력문을 메서드로 만들어서 출력해도 좋다
	
	public Quiz() {
		cnt++;
		stuNum=cnt;
	}
	public void setStuName(String name) {
		stuName=name;
	}
	public void setGender(String gen) {
		gender=gen;
	}
	public void setAddr(String addr) {
		this.addr=addr;
	}
	
	public String getStuName() {
		return stuName;
	}
	public String getGender() {
		return gender;
	}
	public String getAddr() {
		return addr;
	}
	public void printStuInfo() {
		System.out.println("**학생"+stuNum+"정보**");
		System.out.println("이름: "+stuName);
		System.out.println("소속반: "+Quiz.ban);
		System.out.println("성별: "+gender);
		System.out.println("주소: "+addr);
		System.out.println("==================");
	}
	
	
}
public class QuizTest {	

	public static void main(String[] args) {
		
		Quiz.ban="JAVA 4class";
		
		Quiz q1=new Quiz();
		q1.setStuName("이병헌");
		q1.setGender("남자");
		q1.setAddr("서울시 강서구");
		
		q1.printStuInfo();
		
		Quiz q2=new Quiz();
		q2.setStuName("신민아");
		q2.setGender("여자");
		q2.setAddr("서울시 강동구");
		
		q2.printStuInfo();
	
	}
}
