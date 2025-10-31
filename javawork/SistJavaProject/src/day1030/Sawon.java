package day1030;

public class Sawon {

	private String sname;
	private int pay;
	private int familySu;
	private int timeSu;
	
	public static void getTitle() { //getTitle메서드를 통해 기본제목을 출력하는 메서드 선언
		System.out.println("=======================================================================");
		System.out.println("사원명\t급여\t가족수\t초과근무시간\t가족수당\t초과근무수당\t총급여");
		System.out.println("=======================================================================");
		
	}
	


	public String getSname() { //19~49행 사원수 급여 가족수 초과근무시간 getter, setter 메서드 선언
		return sname;		   //이를 통해 사원명 급여 가족수 초과근무시간 조회, 수정 가능
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPay() {
		return pay;
	}
	
	public void setPay(int pay) {
		this.pay = pay;
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


	public int getFamilySudang() { //가족수당 getter 메서드로 조회 가능
		if(familySu>=4)			   //가족수 계산을 통해 정해지므로 따로 setter 메서드 선언 필요X
			return 200000;
		else
			return 50000*familySu;
	}

	public int getTimeSudang() { //초과근무수당 getter 메서드로 조회 가능
		if(timeSu>=10)			 //마찬가지로 초과근무시간 기반 계산한 결과이기때문에 setter 선언 필요X
			return timeSu=300000;
		else
			return 30000*timeSu;
	}

	public int getTotalPay() { //총급여=급여+가족수당+초과근무수당
		
		return pay+getFamilySudang()+getTimeSudang();
	}

}
