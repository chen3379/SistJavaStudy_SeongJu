package day1104;

abstract class Student {
	String name;
	int score;
	
	Student(String name, int score){
		this.name=name;
		this.score=score;
		
	}
	
	abstract void examTake();
	abstract void examSolve();
	abstract void examSubmit();
	
}

class HighStudent extends Student{
	HighStudent(String name, int score) {
		super(name, score);
	}
	@Override
	void examTake() {
		System.out.println(name+"가 교실에서 시험지를 받는다");
	}
	@Override
	void examSolve() {
		System.out.println(name+"가 교실에서 시험지를 푼다");
	}
	@Override
	void examSubmit() {
		System.out.println(name+"가 교실에서 시험지를 제출한다");
	}
	
}

public class Student_241{
	public static void main(String[] args) {
		HighStudent hi;
		hi=new HighStudent("박또치", 100);
		hi.examTake();
		hi.examSolve();
		hi.examSubmit();
	}
}