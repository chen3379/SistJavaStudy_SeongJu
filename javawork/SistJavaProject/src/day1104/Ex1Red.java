package day1104;

//sub
public class Ex1Red extends Ex1Color{

//	public void process() {
//		
//		System.out.println("Red_subclass");
//	}
	
	@Override
	public void process() {
		super.process();
		System.out.println("Red_subclass");
	}
	
	
}
