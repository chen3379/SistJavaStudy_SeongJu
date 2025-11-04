package day1031;

import java.util.Scanner;

public class EmpMain {

	//static 선언함으로 쉽게 가져올 수 있음
	public static void getEmpPay(Emp e) {
		System.out.println(e.getName()+"\t"+e.getPay()+"\t"+e.getSudang()+"\t"+e.getNetPay());
	}

	public static void main(String[] args) {

		//회사명 사원명 급여 수당 입력 후 Emp 테이블 생성 후 set 메서드를 이용하여 초기값을 입력한다 
		//최종적으로 getEmpPay를 호출하여 급여명세서를 사원수만큼 출력한다


		Scanner sc=new Scanner(System.in);

		System.out.println("회사 이름 입력");
		String empName=sc.nextLine();

		//회사이름을 static 멤버변수에 저장
		Emp.setEmpName(empName);

		System.out.println("사원수는?");
		int inwon=Integer.parseInt(sc.nextLine());
		Emp[] emp=new Emp[inwon];
		for(int i=0;i<inwon;i++) {
			emp[i]= new Emp(); //객체 생성
			System.out.println("사원명은? ");
			String name=sc.nextLine();
			System.out.println("급여는? ");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("수당은? ");
			int sudang=Integer.parseInt(sc.nextLine());

			emp[i].setName(name);
			emp[i].setPay(pay);
			emp[i].setSudang(sudang);
		}

		System.out.println("회사명: "+Emp.getEmpName());

		System.out.println("사원명\t급여\t수당\t총급여");
		System.out.println("================================");

		for(Emp e:emp)
			getEmpPay(e);

		for(int i=0;i<inwon;i++) {
			getEmpPay(emp[i]);
		}

		sc.close();
	}
}
