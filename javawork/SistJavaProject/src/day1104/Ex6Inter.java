package day1104;

interface InterA{
	
	public void work();
	public void play();
		
	
}
interface InterB {
	
	public void write();
	
	
}
//2개의 인터페이스를 구현하는 클래스
class InterImpl implements InterB,InterA{
	@Override
	public void play() {
		System.out.println("축구를 합니다");
	}@Override
	public void work() {System.out.println("일을 합니다");
	}@Override
	public void write() {System.out.println("글을 씁니다");
	}
}

public class Ex6Inter {

	public static void main(String[] args) {
		InterA in1=new InterImpl();
		in1.play();
		in1.work();
		InterB in2=new InterImpl();
		in2.write();
		InterImpl in3=new InterImpl();
		in3.play();
		in3.work();
		in3.write();
		
	}
}
