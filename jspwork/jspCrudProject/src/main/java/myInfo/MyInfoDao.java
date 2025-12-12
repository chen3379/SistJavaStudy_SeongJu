package myInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle_db.DBConnect;

public class MyInfoDao {

    DBConnect db = new DBConnect();

    // insert
    public void insertMyInfo(MyInfoDto dto) {
	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "insert into myinfo values(seq1.nextval,?,?,sysdate)";
	try {
	    pstmt = conn.prepareStatement(sql);
	    // 바인딩
	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getAddr());

	    // 업데이트
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}
    }

    // select
//    public Vector<MyInfoDto> getAllDatas() {
//	Vector<MyInfoDto> list = new Vector<MyInfoDto>();
//	return list;
//
//    }

    public List<MyInfoDto> getAllDatas() {
	List<MyInfoDto> list = new Vector<MyInfoDto>();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from myinfo order by num";

	try {
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();

	    // 여러개의 데이터 조회시는 while
	    while (rs.next()) {
		// 반드시 while문 안에서 dto선언
		MyInfoDto dto = new MyInfoDto();

		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setAddr(rs.getString("addr"));
		dto.setSdate(rs.getTimestamp("sdate"));

		// 리스트에 추가
		list.add(dto);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(rs, pstmt, conn);
	}

	return list;
    }

    // delete
    public void deleteMyInfo(String num) {

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "delete from myinfo where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    // ?바인딩
	    pstmt.setString(1, num);
	    // 업데이트
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}

    }

    // update

    // 수정에 필요한 하나의 데이터 조회
    public MyInfoDto getOneData(String num) {

	MyInfoDto dto = new MyInfoDto();

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "select * from myinfo where num=" + num;

	try {
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();

	    // 수정하려는 하나의 데이터만 필요하므로 if
	    if (rs.next()) {
		dto.setNum(rs.getString("num"));
		dto.setName(rs.getString("name"));
		dto.setAddr(rs.getString("addr"));

	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(rs, pstmt, conn);
	}

	return dto;
    }

    // 수정
    public void updateMyInfo(MyInfoDto dto) {

	Connection conn = db.getDBConnect();
	PreparedStatement pstmt = null;

	String sql = "update myinfo set name=?,addr=? where num=?";

	try {
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getName());
	    pstmt.setString(2, dto.getAddr());
	    pstmt.setString(3, dto.getNum());
	    pstmt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    db.dbClose(pstmt, conn);
	}
    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
}
