package day1110;

import java.util.Scanner;

class SawonOuter {

	private String name;
	private int pay;
	private int familySu;
	private int timeSu;

	//내부클래스 생성
	InputInner input =new InputInner();
	SudangInner sudang=new SudangInner();
	
	//내부클래스 처리하는 메서드
	public void process() {
		//데이터 입력
		System.out.println("***사원 급여 정보***");
		input.inputData();
		sudang.getSawonPayWrite();
	}
	
	class InputInner {

		// 사원데이터 입력
		public void inputData() {
			Scanner sc = new Scanner(System.in);
			System.out.println("사원명 입력");
			name = sc.nextLine();
			System.out.println("기본급 입력");
			pay = sc.nextInt();
			System.out.println("가족수 입력");
			familySu = sc.nextInt();
			System.out.println("초과근무시간 입력");
			timeSu = sc.nextInt();

			sc.close();
		}
	}

	class SudangInner {

		// 시간외수당
		public int getTimeSudang() {
			return timeSu * 20000;
		}

		// 가족수당
		public int getFamilySudang() {
			if (familySu >= 3)
				return 200000;
			else
				return 300000;
		}

		// 실제급여
		public int getNetPay() {
			return pay + getFamilySudang() + getTimeSudang();
		}
		
		// 전체출력
		public void getSawonPayWrite() {
			System.out.println("사원명\t기본급\t초과시간수   시간수당   가족수\t가족수당   실수령액");
			System.out.println("===========================================================================");
			System.out.println(name+"\t"+pay+"\t      "+timeSu+"      \t"+getTimeSudang()+"\t  "+familySu+"\t"+getFamilySudang()+"\t    "+getNetPay());
		}
	}
}

public class InnerSawon {

	public static void main(String[] args) {

		SawonOuter sawon=new SawonOuter();
		sawon.process();
	}
}
