package day1030;

class Board{
	
	private String writer;

	private String subject;
	
	private static String comment="게시판 작성하는 날";
	
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static String getComment() {
		return comment;
	}

	public static void setComment(String comment) {
		Board.comment = comment;
	}
	
}



public class Ex4Object {
	
	//Board 의 출력문을 작성
	public static void getBoard(Board b) {
		System.out.println("**Board 클래스 출력**");
		System.out.println("작성자: "+b.getWriter());
		System.out.println("제목: "+b.getSubject());
	}

	public static void main(String[] args) {

		System.out.println("**Board 클래스 comment 출력**");
		System.out.println(Board.getComment());
		
		Board b1=new Board();
		b1.setWriter("김구라");
		b1.setSubject("오늘은 목요일");
		Board b2=new Board();
		b2.setWriter("유재석");
		b2.setSubject("내일은 금요일");
		
		//같은 클래스 내의 static 메서드 호출은 클래스명 생략 가능하다
		getBoard(b1);
		getBoard(b2);
		
		
	}
	
}
