package day1030;

import java.util.Scanner;

public class SawonMain {
	
	public static void getSawonPay(Sawon sawon[]) {
		//Sawon 클래스의 사원별 급여 내역을 조회하는 메서드
		//Sawon 클래스에서 받는 배열을 인자값으로 설정 - sawon
		
		Sawon.getTitle(); //Sawon 클래스의 getTitle 메서드를 받아옴
		
		for(Sawon sa:sawon) //sawon 배열요소 만큼 foreach로 사원별 급여 내역 출력
			System.out.println(sa.getSname()+"\t"+sa.getPay()+"\t "+sa.getFamilySu()+"\t   "+sa.getTimeSu()+"\t\t"
					+sa.getFamilySudang()+"\t "+sa.getTimeSudang()+"\t       "+sa.getTotalPay());
	}

	public static void main(String[] args) {

		//사원수를 입력하여 그 수만큼 사원명 급여 가족수 시간외근무시간을 입력해서
		//그 입력한 값을 생성한다
		Scanner sc=new Scanner(System.in);
		int inwon; //입력받을 사원수 선언
		Sawon sawon[]; //Sawon 클래스 배열을 참조하기 위한 참조변수로 sawon 선언
		System.out.println("입력할 사원 수는 몇명입니까?");
		inwon=Integer.parseInt(sc.nextLine());// 사원수를 inwon에 입력받음
		
		//배열할당
		sawon=new Sawon[inwon]; //sawon에 inwon 크기만큼 배열 할당
		// Sawon sawon[]; sawon= new Sawon[inwon];을 Sawon sawon[]=new Sawon[inwon];으로 가능
		
		//인원수만큼 데이터 입력
		for(int i=0;i<inwon;i++) {
			sawon[i]=new Sawon(); //디폴트생성 , 생성자를 통해 입력 받을 때는 아래쪽에 위치해야함
			System.out.print("사원명: ");
			String name=sc.nextLine();
			System.out.print("\n급여: ");
			int pay=Integer.parseInt(sc.nextLine()); //정수 입력으로 끝나는 게 아닌 for문 반복이기 때문에
			System.out.print("\n가족 수: ");			 //Interger.parstInt로 정수로 변환해서 사용
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