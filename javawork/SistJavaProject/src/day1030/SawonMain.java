package day1030;

import java.util.Scanner;

public class SawonMain {
	
	public static void getSawonPay(Sawon[] sawon) {
		
		Sawon.getTitle();
		
		for(Sawon sa:sawon)
			System.out.println(sa.getSname()+"\t"+sa.getPay()+"\t "+sa.getFamilySu()+"\t   "+sa.getTimeSu()+"\t\t"
					+sa.getFamilySudang()+"\t "+sa.getTimeSudang()+"\t       "+sa.getTotalPay());
	}

	public static void main(String[] args) {

		//사원수를 입력하여 그 수만큼 사원명 급여 가족수 시간외근무시간을 입력해서
		//그 입력한 값을 생성한다
		Scanner sc=new Scanner(System.in);
		int inwon;
		Sawon sawon[];
		System.out.println("입력할 사원 수는 몇명입니까?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//배열할당
		sawon=new Sawon[inwon];
		
		//인원수만큼 데이터 입력
		for(int i=0;i<inwon;i++) {
			sawon[i]=new Sawon();
			System.out.print("사원명: ");
			String name=sc.nextLine();
			System.out.print("\n급여: ");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.print("\n가족 수: ");
			int fs=Integer.parseInt(sc.nextLine());		
			System.out.print("\n초과근무시간: ");
			int ts=Integer.parseInt(sc.nextLine());
			
			//입력한 값이 setter 데이터 초기화
			sawon[i].setSname(name);
			sawon[i].setPay(pay);
			sawon[i].setFamilySu(fs);
			sawon[i].setTimeSu(ts);
		}
		//출력
		getSawonPay(sawon);
		
		sc.close();
	}
	
}
//****쌍용 직원 급여현황***
//
//
//가족수당:  가족당 5만원 (단 4인이상은 무조건 20만원)
//시간수당:  초과근무시간당 3만원 (10시간이상은 무조건 30만으로 통일)
//=============================================================================
//사원명	급여       가족수     초과근무시간      가족수당    초과근무수당   총급여
//=============================================================================
//홍길동  1200000     5           12           200000    300000      1700000

//모든 멤버변수는 private
//사원명: sname
//급여:pay
//가족수:familySu
//초과근무시간: timeSu
//
//
//전체: setter & getter
//
//
//메서드3개
//getFamilySudang()
//getTimeSudang()
//getTotalPay()