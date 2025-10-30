package practice;

class Quiz{
	private String stuName;
	private String gender;
	
	static String ban;
	static String addr;
	static int cnt;
	
	public Quiz(String name,String gen,String addr) {
		this.stuName=name;
		this.gender=gen;
		Quiz.addr=addr;
		cnt++;
	}

	public void printStuInfo() {
		System.out.printf("**학생%d정보**\n이름: %s\n소속반: %s\n성별: %s\n주소: %s\n",
				cnt,stuName,ban,gender,addr);
		System.out.println("===================");
	}
	
}

public class Quiz_1029_practice {
	
	public static void main(String[] args) {
		Quiz.ban="JAVA 4class";
		Quiz q1=new Quiz("이병헌", "남자","서울시 강서구");
		q1.printStuInfo();
		Quiz q2=new Quiz("신민아", "여자","서울시 강동구");
		q2.printStuInfo();
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
	}

}
