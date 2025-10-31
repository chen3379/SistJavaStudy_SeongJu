package day1031;

class Food{

	private String menu;
	private int price;
	static int num;
	
	public void setFood(String menu,int price) {
		this.menu=menu;
		this.price=price;
	}
	
	//출력용
	public void getWriteMenu() {
		num++;
		System.out.println("[메뉴"+num+"]");
		System.out.println("메뉴명: "+menu);
		System.out.println("가격: "+price);
		System.out.println("====================");
	}
	
}


public class ExArrayObject {

	public static void main(String[] args) {

		//디폴트 Food 클래스 생성
		Food[] fd=new Food[3];
		
		for(int i=0;i<fd.length;i++)
			fd[i]=new Food();
		
		fd[0].setFood("피자", 25000);
		fd[1].setFood("알리오올리오", 15000);
		fd[2].setFood("아보카도 샌드위치", 17000);
		
		for(Food f:fd)
			f.getWriteMenu();
	}
}

//[메뉴1]
//메뉴명: 피자
//가격: 25000
//[메뉴2]
//메뉴명: 알리오올리오
//가격: 15000
//[메뉴3]
//메뉴명: 아보카도 샌드위치
//가격: 17000