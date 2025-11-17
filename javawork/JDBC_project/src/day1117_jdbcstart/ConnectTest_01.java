package day1117_jdbcstart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_01 {

	//변수로 드라이버,url
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//메서드..오라클과 자바를 연결(본인의 계정, 비번도 작성)
	public void getConnectEmp() {
		
		Connection conn=null; //DB 연결
		Statement stmt=null; //sql문 실행
		ResultSet rs=null; //조회 결과 저장
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "chen", "admin");
			
			System.out.println("Oracle DB Server 연결 성공");
			
			String sql="select empno,ename,job ,sal from emp order by ename desc";//사원명 내림차순 정렬
			stmt=conn.createStatement();//연결이 되면 sql문 전달
			rs=stmt.executeQuery(sql);//읽을 때 sql
			
			System.out.println("***Emp 데이터 가져오기***");
			System.out.println("사원번호\t사원명\t직무\t급여");
			System.out.println("-------------------------------------------------");
			
			//여러줄의 데이터를 읽어올 경우는 while문으로 가져온다
			//rs.next(): 다음 데이터 읽어오면서 true 반환 , 더 이상 데이터가 없으면 false 반환
			while(rs.next()) {
				
				//db로부터 데이터 가져오기
				int no=rs.getInt("empno");
				String name=rs.getString("ename");
				String job=rs.getString("job");
				int sal=rs.getInt("sal");
				System.out.println("사원번호: "+no+" 이름: "+name+" 직무: "+job+" 급여: "+sal);
			}
			
			
			
		} catch (SQLException e) {
			
//			e.printStackTrace();
			System.out.println("Oracle DB Server 연결 실패"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public void getConnectSawon() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from sawon order by num desc";
		System.out.println("서버 연결 성공");
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"test","admin");
			
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("***사원 정보 출력***");
			System.out.println("사원번호\t이름\t성별\t부서\t급여\t입사일");
			System.out.println("==========================================================");

			while(rs.next()) {
				int no=rs.getInt("num");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
				String ipsa=rs.getString("ipsa");
				System.out.println(no+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay+"\t"+ipsa);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConnectTest_01 con=new ConnectTest_01();
//		con.getConnectEmp();
		con.getConnectSawon();
	}
}
