package spring.ex3.di;

import spring.ex2.di.Person;

public class SawonData {

	private String sawonName;
	private int pay;
	private String ipsaday;
	
	//사원명은 생성자주입
	//pay, ipsaday는 세터주입
	
	public int getPay() {
		return pay;
	}

	public String getIpsaday() {
		return ipsaday;
	}

	public SawonData(String name) {
	
		this.sawonName=name;
		// TODO Auto-generated constructor stub
	}

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}
}
