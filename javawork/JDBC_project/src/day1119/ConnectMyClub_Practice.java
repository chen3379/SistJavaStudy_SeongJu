package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMyClub_Practice {
	DBConnect db = new DBConnect();

	public void insertMyClub(Scanner sc) {
		Connection conn = db.getDBConnect();
		Statement stmt = null;

		System.out.println("[회원정보 등록]");
		System.out.println("성함을 입력해주세요");
		String cname = sc.nextLine();
		System.out.println("주소를 입력해주세요");
		String caddr = sc.nextLine();
		System.out.println("직업을 입력해주세요");
		String cjob = sc.nextLine();
		System.out.println("연락처를 입력해주세요");
		String chp = sc.nextLine();

		String sql = "insert into myclub values(seq1.nextval, '" + cname + "', '" + caddr + "', '" + cjob + "', '" + chp
				+ "',sysdate)";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			System.out.println("[회원정보 등록 완료]");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public void selectMyClub() {
		Connection conn = db.getDBConnect();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from myclub";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("[회원정보 조회]");
			System.out.println("===================================================================");
			System.out.println("회원번호\t회원명\t주소\t직업\t연락처\t\t등록일자");
			System.out.println("===================================================================");

			while (rs.next()) {
				System.out.println(rs.getInt("cno") + "\t" + rs.getString("cname") + "\t" + rs.getString("caddr") + "\t"
						+ rs.getString("cjob") + "\t" + rs.getString("chp") + "\t" + rs.getString("gaipday"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

	}

	public void deleteMyClub(Scanner sc) {
		Connection conn = db.getDBConnect();
		Statement stmt = null;

		int num;

		System.out.println("[회원정보 삭제]");
		System.out.println("삭제할 회원번호를 입력해주세요");
		num = Integer.parseInt(sc.nextLine());

		String sql = "delete from myclub where cno =" + num;

		try {
			stmt = conn.createStatement();
			if (!isOneData(num)) {
				System.out.println("회원번호가 존재하지 않습니다");
				return;
			}
			stmt.execute(sql);
			System.out.println("[회원정보 삭제 완료]");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public boolean isOneData(int n) {
		boolean flag = false;

		Connection conn = db.getDBConnect();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from myclub where cno=" + n;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next())
				flag = true;
			else
				flag = false;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

		return flag;
	}

	public void updateMyClub(Scanner sc) {

		Connection conn = db.getDBConnect();
		Statement stmt = null;

		int num;

		System.out.println("[회원정보 수정]");
		System.out.println("수정할 회원번호를 입력해주세요");
		num = Integer.parseInt(sc.nextLine());

		if (!isOneData(num)) {
			System.out.println("회원번호가 존재하지 않습니다");
			return;
		}
		System.out.println("수정할 정보를 입력해주세요");
		System.out.println("성함을 입력하세요");
		String cname = sc.nextLine();
		System.out.println("주소를 입력하세요");
		String caddr = sc.nextLine();
		System.out.println("직업을 입력하세요");
		String cjob = sc.nextLine();
		System.out.println("연락처를 입력하세요");
		String chp = sc.nextLine();

		String sql = "update myclub set cname= '" + cname + "', caddr= '" + caddr + "', cjob = '" + cjob + "', chp = '"
				+ chp + "' where cno=" + num;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("[회원정보 수정 완료]");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}
	
	//회원명의 일부를 입력시 조회되게 만들기
	public void searchMyClub(Scanner sc) {
		Connection conn=db.getDBConnect();
		Statement stmt=null;
		ResultSet rs=null;
		
		System.out.println("검색할 회원명을 입력하세요");
		String sname=sc.nextLine();
		
		String sql="select * from myclub where cname like '%"+sname+"%'";
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("===================================================================");
			System.out.println("회원번호\t회원명\t주소\t직업\t연락처\t\t등록일자");
			System.out.println("===================================================================");

			while (rs.next()) {
				System.out.println(rs.getInt("cno") + "\t" + rs.getString("cname") + "\t" + rs.getString("caddr") + "\t"
						+ rs.getString("cjob") + "\t" + rs.getString("chp") + "\t" + rs.getString("gaipday"));
			}
			System.out.println("===================================================================");
			System.out.println("[회원정보 검색 완료]");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ConnectMyClub_Practice cl = new ConnectMyClub_Practice();
		int optionNum;

		System.out.println("MyClub_CRUD_Test");
		while (true) {
			System.out.println("[메뉴 선택]");
			System.out.println("===================================================================");
			System.out.println("1.회원가입  2.회원조회  3.회원삭제  4.회원정보수정  5.회원정보검색  9.종료");
			System.out.println("===================================================================");

			optionNum = Integer.parseInt(sc.nextLine());

			switch (optionNum) {
			case 1:
				cl.insertMyClub(sc);
				break;
			case 2:
				cl.selectMyClub();
				break;
			case 3:
				cl.deleteMyClub(sc);
				break;
			case 4:
				cl.updateMyClub(sc);
				break;
			case 5:
				cl.searchMyClub(sc);
				break;
			case 9:
				System.out.println("[프로그램 종료]");
				System.exit(0);
			default:
				System.out.println("!! 다시 입력해주세요");
				break;
			}
		}
	}
}
