package day1119;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	String driver="oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public DBConnect() {
		
		try {
			Class.forName(driver);
			System.out.println("# 오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			
			System.out.println("# 오라클 드라이버 실패");
			e.printStackTrace();
		}
	}
	
	//오라클서버연결메서드(Connection)
	public Connection getDBConnect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "vaundy", "admin");
//			System.out.println("#오라클 서버연결 성공");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	//close메서드
	public void dbClose(ResultSet rs, Statement stmt,Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void dbClose(Statement stmt,Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DBConnect db=new DBConnect();
		
	}
}
