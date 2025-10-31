package day1031;

public class Emp {
	
	private String name;
	private int pay;
	private int sudang;
	
	private static String empName; //회사명

	//name,pay,sudang,empName setter&getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getSudang() {
		return sudang;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}

	public static String getEmpName() {
		return empName;
	}

	public static void setEmpName(String empName) {
		Emp.empName = empName;
	}
	
	//실수령액
	public int getNetPay() {
		return (int)((pay+sudang)*0.9);
	}
	
	
}
