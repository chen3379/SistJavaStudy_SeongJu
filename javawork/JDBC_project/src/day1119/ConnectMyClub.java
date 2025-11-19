package day1119;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectMyClub {

	DBConnect db = new DBConnect();

	// insert
	// 회원가입하기
	// 회원명 주소 직업 핸드폰
	public void insertMyClub(Scanner sc) {

		Connection conn = db.getDBConnect();
		Statement stmt = null;

		System.out.println("성함을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = sc.nextLine();
		System.out.println("직업을 입력해주세요");
		String job = sc.nextLine();
		System.out.println("연락처를 입력해주세요");
		String hp = sc.nextLine();

		String sql = "insert into myclub values(seq1.nextval,'" + name + "','" + addr + "','" + job + "','" + hp
				+ "',sysdate)";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			System.out.println("[회원님의 정보가 등록되었습니다");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// select---5명 이상 조회 1장 캡쳐
	public void selectMyClub() {
		Connection conn = db.getDBConnect();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from myclub order by cno";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("===================================================================");
			System.out.println("회원번호\t회원명\t주소\t직업\t연락처\t\t가입일자");
			System.out.println("===================================================================");
			while (rs.next()) {
				System.out.println(rs.getInt("cno") + "\t" + rs.getString("cname") + "\t" + rs.getString("caddr") + "\t"
						+ rs.getString("cjob") + "\t" + rs.getString("chp") + "\t" + rs.getString("gaipday"));
			}
			System.out.println("===================================================================");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

	}

	// delete
	public void deleteMyClub(Scanner sc) {
		Connection conn = db.getDBConnect();
		Statement stmt = null;
		int n;
		System.out.println("삭제할 회원번호를 입력해주세요");
		n = Integer.parseInt(sc.nextLine());
		String sql = "delete from myclub where cno=" + n;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			System.out.println(n + "번 회원정보가 삭제되었습니다");
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
			db.dbClose(rs, stmt, conn);
		}

		return flag;
	}

	// update
	public void updateMyClub(Scanner sc) {
		Connection conn = db.getDBConnect();

		Statement stmt = null;
		int n;

		System.out.println("수정할 회원번호를 입력해주세요");

		n = Integer.parseInt(sc.nextLine());

		if (!isOneData(n)) {
			System.out.println("해당 회원번호는 존재하지 않습니다");
			return;
		}

		System.out.println("수정할 회원명을 입력해주세요");
		String cname = sc.nextLine();
		System.out.println("수정할 주소를 입력해주세요");
		String caddr = sc.nextLine();
		System.out.println("수정할 직업을 입력해주세요");
		String cjob = sc.nextLine();
		System.out.println("수정할 연락처를 입력해주세요");
		String chp = sc.nextLine();
		String sql = "update myclub set cname='" + cname + "',caddr='" + caddr + "',cjob='" + cjob + "',chp='" + chp
				+ "' where cno=" + n;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

			System.out.println(n + "번 회원의 정보가 수정되었습니다");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public static void main(String[] args) {
		ConnectMyClub cm = new ConnectMyClub();
		Scanner sc = new Scanner(System.in);

		// 반복문으로 1.회원가입 2.회원조회 3.회원삭제 4.회원정보수정 9.종료
		int n;

		System.out.println("[DB: MYCLUB]");

		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.회원가입  2.회원조회  3.회원삭제  4.회원정보수정  9.종료");
			System.out.println("-----------------------------------------------");

			n = Integer.parseInt(sc.nextLine());

			switch (n) {
			case 1:
				cm.insertMyClub(sc);
				break;
			case 2:
				cm.selectMyClub();
				break;
			case 3:
				cm.deleteMyClub(sc);
				break;
			case 4:
				cm.updateMyClub(sc);
				break;
			case 9:
				System.out.println("[시스템 종료]");
				System.exit(0);
			default:
				System.out.println("다른 숫자를 입력해주세요");
				break;

			}

		}

	}
}
