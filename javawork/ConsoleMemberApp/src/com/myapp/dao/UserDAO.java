package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myapp.domain.User;

public class UserDAO {

	// DB 접속 정보(추후에 별도 파일 분리)
	private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String DB_USER = "chen";
	private final String DB_PASSWORD = "admin";

	// DB 연결 객체를 반환하는 헬퍼 메소드
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	// 1.회원 생성(Create)
	public void createUser(User user) {
		String sql = "INSERT INTO users (id, password,name,join_date) VALUES (?,?,?, SYSDATE)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());

			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// 자원 해제(필수)
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
	
	//2.회원 조회 (Read)
	public User findUserById(String id) {
		String sql= "SELECT * FROM users WHERE id =?";
		User user=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		return user;
		
	}

}
