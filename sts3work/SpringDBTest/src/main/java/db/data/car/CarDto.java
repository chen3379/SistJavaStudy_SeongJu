package db.data.car;

public class CarDto {

	private int num;
	private String cname;
	private String ccolor;
	private int cprice;
	private String cguip;

	public String getCguip() {
		return cguip;
	}

	public void setCguip(String cguip) {
		this.cguip = cguip;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcolor() {
		return ccolor;
	}

	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}

	public int getCprice() {
		return cprice;
	}

	public void setCprice(int cprice) {
		this.cprice = cprice;
	}

}
