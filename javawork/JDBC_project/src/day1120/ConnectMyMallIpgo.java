package day1120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day1119.DBConnect;

public class ConnectMyMallIpgo {

	Scanner sc = new Scanner(System.in);

	// Connect,dbclose 메서드가 있는 클래스 생
	DBConnect db = new DBConnect();

	// isOneDate 메서드(상품 데이터 존재 판별)
	public boolean isOneData(int n) {
		boolean flag = false;

		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mymallipgo where num=?";

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

	// insert
	public void insertMyMallIpgo() {

		System.out.println("[신규 상품 등록]");
		System.out.println("카테고리 입력(음료,과자류)");
		String category = sc.nextLine();
		System.out.println("상품명 입력");
		String sangpum = sc.nextLine();
		System.out.println("수량 입력");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("가격 입력");
		int price = Integer.parseInt(sc.nextLine());

		// 완성된 sql
//		String sql="insert into mymallipgo values(seq1.nextval,'"+category+"','"+sangpum+"',"+su+","+price+",sysdate";

		// PrepareStatement객체는 미완성된 sql문을 작성할 수 있다
		// 변수를 ?로 표시 후 나중에 바인딩 시켜준다
		String sql = "insert into mymallipgo values(seq1.nextval,?,?,?,?,sysdate)";

		// db연결
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			// ? 순서대로 바인딩
			pstmt.setString(1, category);
			pstmt.setString(2, sangpum);
			pstmt.setInt(3, su);
			pstmt.setInt(4, price);

			// 업데이트
			int a = pstmt.executeUpdate();

			if (a == 1)
				System.out.println("[등록 완료]");
			else
				System.out.println("!!등록 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// select
	public void selectMyMallIpgo() {
		Connection conn = db.getDBConnect();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from mymallipgo order by category";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("-----------------------------------------------------------");
			System.out.println("상품번호\t카테고리\t상품명\t재고\t상품가격\t입고일자");
			System.out.println("-----------------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("num") + "번\t" + rs.getString("category") + "\t" + rs.getString("sangpum")
						+ "\t" + rs.getInt("su") + "개\t" + rs.getInt("price") + "원\t" + rs.getString("ipgo"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

	}

	// delete
	public void deleteMyMallIpgo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 상품번호를 입력하세요");
		int dNum = Integer.parseInt(sc.nextLine());

		String sql = "delete from mymallipgo where num=?";

		if (!isOneData(dNum)) {
			System.out.println("존재하지 않는 상품번호입니다");
			return;
		}

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dNum);
			int result = pstmt.executeUpdate();

			if (result == 1)
				System.out.println("[상품 삭제 완료]");
			else
				System.out.println("!!삭제 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// update
	public void updateMyMallIpgo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;

		System.out.println("수정할 상품번호를 입력하세요");
		int uNum = Integer.parseInt(sc.nextLine());

		String sql = "update mymallipgo set category=?,sangpum=?,su=?,price=? where num=?";

		if (!isOneData(uNum)) {
			System.out.println("존재하지 않는 상품번호입니다");
			return;
		}

		System.out.println("[등록 상품 수정]");
		System.out.println("카테고리를 입력하세요");
		String category = sc.nextLine();
		System.out.println("상품명을 입력하세요");
		String sangpum = sc.nextLine();
		System.out.println("수량을 입력하세요");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("가격을 입력하세요");
		int price = Integer.parseInt(sc.nextLine());

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, sangpum);
			pstmt.setInt(3, su);
			pstmt.setInt(4, price);
			pstmt.setInt(5, uNum);
			int result = pstmt.executeUpdate();

			if (result == 1)
				System.out.println("[" + uNum + "번 상품 수정 완료]");
			else
				System.out.println("!!수정 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	public void findMyMallIpgo() {
		Connection conn = db.getDBConnect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("[상품 검색]");
		System.out.println("찾으시는 상품명을 입력해주세요");
		String findSangpum = sc.nextLine();

		String sql = "select * from mymallipgo where sangpum like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+findSangpum+"%");

			rs = pstmt.executeQuery();

			System.out.println("-----------------------------------------------------------");
			System.out.println("상품번호\t카테고리\t상품명\t재고\t상품가격\t입고일자");
			System.out.println("-----------------------------------------------------------");
			
			while (rs.next()) {
				System.out.println(rs.getInt("num") + "번\t" + rs.getString("category") + "\t" + rs.getString("sangpum")
						+ "\t" + rs.getInt("su") + "개\t" + rs.getInt("price") + "원\t" + rs.getString("ipgo"));
			}
			System.out.println("[검색 완료]");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	// write_process(출력문 메서드)
	public void processMyMallIpgo() {

		System.out.println("***[상품 관리]***");
		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.상품입고  2.상품재고현황  3.상품삭제  4.상품정보수정  5.상품검색  9.종료");
			System.out.println("------------------------------------------------------------");

			int itemNum = Integer.parseInt(sc.nextLine());

			switch (itemNum) {
			case 1:
				insertMyMallIpgo();
				break;
			case 2:
				selectMyMallIpgo();
				break;
			case 3:
				deleteMyMallIpgo();
				break;
			case 4:
				updateMyMallIpgo();
				break;
			case 5:
				findMyMallIpgo();
				break;
			case 9:
				System.out.println("시스템 종료");
				System.exit(0);
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		ConnectMyMallIpgo cm = new ConnectMyMallIpgo();
		cm.processMyMallIpgo();

	}
}
