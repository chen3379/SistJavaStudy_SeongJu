package day1104;

interface InterColor{
	
	String INITCOLOR="white";
	public void paintColor();
	
}

class Red implements InterColor{
	@Override
	public void paintColor() {
		System.out.println(INITCOLOR+" 컬러로 도색합니다");
		System.out.println("레드 컬러로 도색합니다");
	}
}

class Green implements InterColor{
	@Override
	public void paintColor() {
		System.out.println(INITCOLOR+" 컬러로 도색합니다");
		System.out.println("그린 컬러로 도색합니다");
	}
}

class Blue implements InterColor{
	@Override
	public void paintColor() {
		System.out.println(INITCOLOR+" 컬러로 도색합니다");
		System.out.println("블루 컬러로 도색합니다");
	}
}

public class Ex7Enter {

	public static void main(String[] args) {
		InterColor cl;
		cl=new Red();
		cl.paintColor();
		cl=new Blue();
		cl.paintColor();
		cl=new Green();
		cl.paintColor();
	}
}
