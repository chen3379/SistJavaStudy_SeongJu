package myboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mysql.db.DBConnect;

public class BoardAnswerDao {

  DBConnect db = new DBConnect();

  // insert
  public void insertBoardAnswer(BoardAnswerDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into myboardanswer values(null,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getNum());
      pstmt.setString(2, dto.getNickname());
      pstmt.setString(3, dto.getComment());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }


  // 전체댓글출력
  public List<BoardAnswerDto> getAllAnswer(String num) {
    List<BoardAnswerDto> list = new ArrayList<BoardAnswerDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myboardanswer where num=" + num;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardAnswerDto dto = new BoardAnswerDto();

        dto.setIdx(rs.getString("idx"));
        dto.setNum(rs.getString("num"));
        dto.setNickname(rs.getString("nickname"));
        dto.setComment(rs.getString("comment"));
        dto.setWriteday(rs.getTimestamp("writeday"));

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

  public void deleteAnswer(String idx) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from myboardanswer where idx=" + idx;

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

  // 수정_idx에 대한 하나의 dto 리턴
  public BoardAnswerDto getAnswerData(String idx) {
    BoardAnswerDto dto = new BoardAnswerDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myboardanswer where idx=" + idx;

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setIdx(rs.getString("idx"));
        dto.setNum(rs.getString("num"));
        dto.setNickname(rs.getString("nickname"));
        dto.setComment(rs.getString("comment"));
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

  // 수정
  public void updateAnswer(BoardAnswerDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "update myboardanswer set nickname=?,comment=? where idx=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getNickname());
      pstmt.setString(2, dto.getComment());
      pstmt.setString(3, dto.getIdx());
      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }



}
