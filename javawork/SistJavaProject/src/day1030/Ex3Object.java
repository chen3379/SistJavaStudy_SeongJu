package day1030;

class StuScore{
	
	private String stuName;
	private int java;
	private int oracle;
	
	static final String TITLE="자바오라클 중간시험";

	//각각의 setter, getter
	
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	
	//합계메서드	
	public int getSum() {
		return java+oracle; 
	}
	
	//평균메서드
	public double getAvg() {
		return (double)getSum()/2;
	}

}


public class Ex3Object {

	public static void main(String[] args) {
		
		StuScore s1=new StuScore();
		
		s1.setStuName("박호준");
		s1.setJava(87);
		s1.setOracle(99);
		
		System.out.printf("%s\n이름: %s\n자바점수: %d점\n오라클점수: %d점\n합계: %d점\n평균: %.1f점",
				StuScore.TITLE,s1.getStuName(),s1.getJava(),s1.getOracle(),s1.getSum(),s1.getAvg());
	}
}
