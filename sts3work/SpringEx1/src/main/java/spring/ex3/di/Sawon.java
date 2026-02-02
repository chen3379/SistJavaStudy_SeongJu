package spring.ex3.di;

public class Sawon {

	SawonData data;

	public Sawon(SawonData data) {
		this.data=data;
		
		
	}
	public void writeData() {
		System.out.println("사원명: "+data.getSawonName());
		System.out.println("급여: "+data.getPay());
		System.out.println("입사일: "+data.getIpsaday());
	}
}
