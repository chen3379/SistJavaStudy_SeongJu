package day1030;

class MyInfo{
	
	private String name;
	private String mbti;
	private int age;
	
	//명시적생성자3개짜리
	public MyInfo(String name,String mbti,int age) {
		this.name=name;
		this.mbti=mbti;
		this.age=age;
	}
	
	//제목 static
	public static void title() {
		System.out.println("이름\tMBTI\t나이");
		System.out.println("====================");
	}
	//출력용
	public void getMyInfo() {
		System.out.println(name+"\t"+mbti+"\t"+age+"세");
	}
	
}


public class Ex7ArrayObject {

	public static void main(String[] args) {
		
//		총 3명의 정보 출력
//		
//		for문 foreach문 1번씩 생성
//		이름 MBTI 나이
//		==============
//		김민희 ENFJ 26세
//		김희애 ISTP 30세
//		이효리 ESTJ 35세
//		==============
		
		MyInfo m[]=new MyInfo[3];
		m[0]=new MyInfo("김민희", "ENFJ", 26);
		m[1]=new MyInfo("김희애", "ISTP", 30);
		m[2]=new MyInfo("이효리", "ESTJ", 35);
		
		System.out.println("총 3명의 정보 출력\n");
		
		//for
		MyInfo.title();
		for(int i=0;i<m.length;i++) {
			m[i].getMyInfo();
		}
		
		//foreach
		System.out.println("====================");
		MyInfo.title();
		for(MyInfo a:m) {
			a.getMyInfo();
		}
	}
}
