package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day1119.DBConnect;

public class ConnectMyStudentInfo {
	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);

	public void insertInfo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;

		System.out.println("[학생정보등록]");
		System.out.println("학생명 입력");
		String stu_name = sc.nextLine();
		System.out.println("주소 입력");
		String stu_addr = sc.nextLine();
		System.out.println("학년 입력");
		int stu_grade = Integer.parseInt(sc.nextLine());
		System.out.println("혈액형 입력(A,B,O,AB)");
		String stu_blood = sc.nextLine();
		System.out.println("출생년도 입력");
		String stu_birth = sc.nextLine();
		String sql = "insert into mystudentinfo values(seq1.nextval,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_name);
			pstmt.setString(2, stu_addr);
			pstmt.setInt(3, stu_grade);
			pstmt.setString(4, stu_blood);
			pstmt.setString(5, stu_birth);
			int a = pstmt.executeUpdate();

			if (a == 1)
				System.out.println("등록 완료");
			else
				System.out.println("등록 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	public void selectInfo() {
		Connection conn = db.getDBConnect();
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("===========================================================================");
		System.out.println("번호\t학생명\t주소\t학년\t혈액형\t출생년도\t\t등록일자");
		System.out.println("===========================================================================");
		String sql = "select * from mystudentinfo";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("stu_no") + "번\t" + rs.getString("stu_name") + "\t"
						+ rs.getString("stu_addr") + "\t" + rs.getInt("stu_grade") + "학년\t" + rs.getString("stu_blood")
						+ "형\t" + rs.getString("stu_birth") + "\t" + rs.getString("writeday"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

	}
	
	public boolean isOneData(int n) {
		boolean flag = false;

		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select 1 from mystudentinfo where stu_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n);
			rs = pstmt.executeQuery();

			if (rs.next())
				flag = true;
			else
				flag = false;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return flag;
	}

	public void deleteInfo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 학생번호를 입력해주세요");
		int dNum = Integer.parseInt(sc.nextLine());

		if(!isOneData(dNum)) {
			System.out.println("존재하지 않는 학생번호입니다");
			return;
		}
		String sql = "delete from mystudentinfo where stu_no=?";			
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dNum);
			int a = pstmt.executeUpdate();

			if (a == 1)
				System.out.println(dNum+"번 삭제 완료");
			else
				System.out.println("삭제 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void updateInfo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		System.out.println("수정할 학생번호를 입력하세요");
		int uNum = Integer.parseInt(sc.nextLine());
		
		if(!isOneData(uNum)) {
			System.out.println("존재하지 않는 학생번호입니다");
			return;
		}

		System.out.println("학생명 입력");
		String stu_name = sc.nextLine();
		System.out.println("주소 입력");
		String stu_addr = sc.nextLine();
		System.out.println("학년 입력");
		int stu_grade = Integer.parseInt(sc.nextLine());
		System.out.println("혈액형 입력(A,B,O,AB)");
		String stu_blood = sc.nextLine();
		System.out.println("출생년도 입력");
		String stu_birth = sc.nextLine();

		String sql = "update mystudentinfo set stu_name=?,"
				+ "stu_addr=?,stu_grade=?,stu_blood=?,stu_birth=? where stu_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_name);
			pstmt.setString(2, stu_addr);
			pstmt.setInt(3, stu_grade);
			pstmt.setString(4, stu_blood);
			pstmt.setString(5, stu_birth);
			pstmt.setInt(6, uNum);
			int a = pstmt.executeUpdate();

			if (a == 1)
				System.out.println(uNum+"번 수정 완료");
			else
				System.out.println("수정 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	public void searchInfo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("[학생정보검색]");
		System.out.println("성을 입력해주세요");
		String fname = sc.nextLine();
		String sql = "select * from mystudentinfo where stu_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname + "%");
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("성이 '" + fname + "'인 학생이 존재하지 않습니다");
				return;
			}

			System.out.println("성이 '" + fname + "'인 학생정보");
			System.out.println("===========================================================================");
			while (rs.next()) {
				System.out.println(rs.getInt("stu_no") + "\t" + rs.getString("stu_name") + "\t"
						+ rs.getString("stu_addr") + "\t" + rs.getInt("stu_grade") + "\t" + rs.getString("stu_blood")
						+ "\t" + rs.getString("stu_birth") + "\t" + rs.getString("writeday"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	public void processInfo() {

		System.out.println("MyStudentInfo CRUD");
		while (true) {
			System.out.println("===========================================================================");
			System.out.println("1.학생정보등록  2.학생정보조회  3.학생정보삭제  4.학생정보수정  5.학생정보검색(성)  9.종료");
			System.out.println("===========================================================================");

			System.out.println("번호를 입력해주세요");
			int n = Integer.parseInt(sc.nextLine());

			switch (n) {
			case 1:
				insertInfo();
				break;
			case 2:
				selectInfo();
				break;
			case 3:
				deleteInfo();
				break;
			case 4:
				updateInfo();
				break;
			case 5:
				searchInfo();
				break;
			case 9:
				System.out.println("[프로그램 종료]");
				System.exit(0);
			default:
				System.out.println("메뉴에 해당하는 번호를 입력해주세요");
				break;
			}
		}
	}

	public static void main(String[] args) {
		ConnectMyStudentInfo in = new ConnectMyStudentInfo();
		in.processInfo();

	}
}
