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

    String sql = "insert into myboard values(null,?,?,?,0,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getPass());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // 조회수 증가
  public void updateReadcount(String num) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update myboard set readcount=readcount+1 where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // num에 대한 하나의 dto
  public BoardDto getOneData(String num) {
    BoardDto dto = new BoardDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myboard where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setPass(rs.getString("pass"));
        dto.setWriteday(rs.getTimestamp("writeday"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

    return dto;
  }

  // 비밀번호 맞는지 체크(pass)
  public Boolean isEqualPass(String num, String pass) {
    boolean flag = false;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select count(*) from myboard where num=? and pass=?";
    // 각 num 번호를 가진 데이터마다 고유 pass가 있으므로 num과 pass가 일치하면 1, 틀리면 0
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        if (rs.getInt(1) == 1)
          flag = true;
        // 초기값이 false 이므로 0인 경우 false는 전달 안해도됨
      }


    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


    return flag;
  }

  // 삭제
  public void deleteBoard(String num) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from myboard where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // 수정
  public void updateBoard(BoardDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update myboard set writer=?,subject=?,content=? where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getNum());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }


  }

  // 부분조회(startNum 부터 perPage개수만큼 반환)
  public List<BoardDto> getPagingList(int startNum, int perPage) {
    List<BoardDto> list = new ArrayList<BoardDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myboard order by num desc limit ?,?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, startNum);
      pstmt.setInt(2, perPage);

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
}
