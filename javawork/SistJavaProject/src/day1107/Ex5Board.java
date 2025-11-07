package day1107;

public class Ex5Board {

	private String writer;
	private String subject;
	private String content;

	// 디폴트 생성자
	public Ex5Board() {
	}

	// 명시적 생성자 - 생성과 동시에 초기값까지 지정
	public Ex5Board(String writer, String subject, String content) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;

	}

	// set get
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
