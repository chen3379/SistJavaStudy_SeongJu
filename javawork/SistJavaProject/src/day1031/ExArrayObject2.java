package day1031;

class Menu{
	private String foodName;
	private int price;
	private String tasty;

	private static int num; //메뉴번호

	// 명시적생성자
	public Menu(String foodName,int price,String tasty) {
		this.foodName=foodName;
		this.price=price;
		this.tasty=tasty;
	}	

	// 제목 출력 메서드 구현
	public static void showTitle() {
		System.out.println("No.\t음식명\t가격\t맛평가");
		System.out.println("================================");
	}

	// 출력 메서드 구현
	public void getMenu() {
		num++;
		System.out.println(num+"\t"+foodName+"\t"+price+"\t"+tasty);
	}
}


public class ExArrayObject2 {

	public static void main(String[] args) {

		//개별출력
		Menu m1=new Menu("춘천막국수", 11000, "추천메뉴");
		Menu m2=new Menu("감자전", 9000, "인기메뉴");
		Menu m3=new Menu("메밀전병", 8000, "1위메뉴");
		Menu m4=new Menu("닭갈비", 15000, "흑백요리사");

		Menu.showTitle();
		m1.getMenu();
		m2.getMenu();
		m3.getMenu();
		m4.getMenu();

		//배열출력
		Menu[] menu= {
				new Menu("춘천막국수", 11000, "추천메뉴"),
				new Menu("감자전", 9000, "인기메뉴"),
				new Menu("메밀전병", 8000, "1위메뉴"),
				new Menu("닭갈비", 15000, "흑백요리사")};
		
		//배열출력_for
		System.out.println();
		Menu.showTitle();
		for(int i=0;i<menu.length;i++)
			menu[i].getMenu();
		
		//배열출력_foreach
		System.out.println();
		Menu.showTitle();
		for(Menu m:menu)
			m.getMenu();
	}

}

// No.	음식명	가격		맛평가
// ============================
// 1	춘천막국수	11000	추천메뉴
// 2	감자전	9000	인기메뉴
// 3	메밀전병	8000	1위메뉴
// 4	닭갈비	15000	흑백요리사