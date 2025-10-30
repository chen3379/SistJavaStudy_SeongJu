package day1030;

public class Sawon {

	private String sname;
	private int pay;
	private int familySu;
	private int timeSu;
	
	public static void getTitle() {
		System.out.println("=======================================================================");
		System.out.println("사원명\t급여\t가족수\t초과근무시간\t가족수당\t초과근무수당\t총급여");
		System.out.println("=======================================================================");
		
	}
	
	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getFamilySu() {
		return familySu;
	}

	public void setFamilySu(int familySu) {
		this.familySu = familySu;
	}

	public int getTimeSu() {
		return timeSu;
	}

	public void setTimeSu(int timeSu) {
		this.timeSu = timeSu;
	}


	public int getFamilySudang() {
		if(familySu>=4)
			return 200000;
		else
			return 50000*familySu;
	}

	public int getTimeSudang() {
		if(timeSu>=10)
			return timeSu=300000;
		else
			return 30000*timeSu;
	}

	public int getTotalPay() {
		
		return pay+getFamilySudang()+getTimeSudang();
	}

}
