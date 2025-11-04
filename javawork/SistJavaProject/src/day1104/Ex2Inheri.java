package day1104;

//super
class Work{
	
	public void process() {
		System.out.println("Work");
	}
}
//sub1
class Man extends Work{
	
	@Override
	public void process() {
		super.process();
		System.out.println("hi");
	}
}
//sub2
class Room extends Work{
	
	@Override
	public void process() {
		super.process();
		System.out.println("WorkRoom");
	}
}


public class Ex2Inheri {

	public static void main(String[] args) {
		System.out.println("1.자식클래스로 선언과 생성");
		Man man=new Man();
		man.process();
		Room room=new Room();
		room.process();
		System.out.println("---------------------------");
		System.out.println("2.부모클래스로 선언과 생성");
		Work man2=new Man();
		man2.process();
		Work room2=new Room();
		room2.process();
	}
}
