package day1107;

public class QuizShop {

	private String name;
	private String color;
	private String made;
	private int num;
	private int price;
	
	private int totalPrice;
	
	//setter getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//totalprice method
	public void setTotalPrice(int num,int price) {
		totalPrice=num*price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
}
