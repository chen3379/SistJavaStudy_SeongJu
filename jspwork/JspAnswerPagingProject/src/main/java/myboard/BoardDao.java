package myboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mysql.db.DBConnect;

public class BoardDao {

  DBConnect db = new DBConnect();

  // 전체조회
  public List<BoardDto> getAllDatas() {
    List<BoardDto> list = new ArrayList<BoardDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myboard order by num desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardDto dto = new BoardDto();

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setPass(rs.getString("pass"));
        dto.setWriteday(rs.getTimestamp("writeday"));

        // list에 추가
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

  // 전체 갯수 반환(페이징처리 _ 1.전체갯수) - totalcount를 계산해서 %10==0일 때 페이징 등 처리 가능
  public int getTotalCount() {

    int total = 0;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null; // 반환타입이 있으면 resultset 필요

    String sql = "select count(*) from myboard";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        total = rs.getInt(1); // 1번 열
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }


    return total;
  }

  // insert
  public void insertBoard(BoardDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into myboard values(null,?,?,?,null,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getPass());
      pstmt.setString(4, dto.getContent());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // 조회수 증가

  // num에 대한 하나의 dto

  // 비밀번호 맞는지 체크(pass)

  // 삭제

  // 수정
}
