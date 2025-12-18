package simpleboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DBConnect;

public class BoardDao {

  DBConnect db = new DBConnect();

  // insert
  public void insertBoard(BoardDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    String sql = "insert into simpleboard values(null,?,?,?,?,?,0,now())";

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getContent());
      pstmt.setString(4, dto.getImgname());
      pstmt.setString(5, dto.getPass());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // select
  public List<BoardDto> getAllDatas() {
    List<BoardDto> list = new Vector<BoardDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from simpleboard order by num desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardDto dto = new BoardDto();
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setPass(rs.getString("pass"));
        dto.setContent(rs.getString("content"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setWriteday(rs.getTimestamp("writeday"));
        dto.setImgname(rs.getString("imgname"));

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

  // select one
  public BoardDto getOneData(String num) {
    BoardDto dto = new BoardDto();
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from simpleboard where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setPass(rs.getString("pass"));
        dto.setContent(rs.getString("content"));
        dto.setReadcount(rs.getInt("readcount"));
        dto.setWriteday(rs.getTimestamp("writeday"));
        dto.setImgname(rs.getString("imgname"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }


    return dto;
  }

  // delete
  public void deleteBoard(String num) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from simpleboard where num=" + num;

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

  // update
  public void updateBoard(BoardDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update simpleboard set writer=?,subject=?,imgname=?,content=? where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getWriter());
      pstmt.setString(2, dto.getSubject());
      pstmt.setString(3, dto.getImgname());
      pstmt.setString(4, dto.getContent());
      pstmt.setString(5, dto.getNum());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

  // 조회수 1 증가하는 메서드
  public void updateReadcount(String num) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update simpleboard set readcount=readcount+1 where num=" + num;

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

  // password 검증 메서드 - num과 pass를 받아서 비번이 맞으면 true,그렇지 않으면 false 를 반환하는 메서드
  public Boolean isEqualPass(String num, String pass) {
    boolean flag = false;

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select count(*) from simpleboard where num=? and pass=?";
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



}
