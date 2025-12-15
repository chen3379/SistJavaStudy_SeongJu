package intro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DBConnect;

public class IntroDao {

  DBConnect db = new DBConnect();

  // 전체데이터 조회
  // select
  public List<IntroDto> getAllIntros() {
    List<IntroDto> list = new Vector<IntroDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from intro order by num";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {

        IntroDto dto = new IntroDto();

        dto.setNum(rs.getString("num"));
        dto.setName(rs.getString("name"));
        dto.setBirthday(rs.getString("birthday"));
        dto.setHp(rs.getString("hp"));
        dto.setHometown(rs.getString("hometown"));
        dto.setHobby(rs.getString("hobby"));
        dto.setMbti(rs.getString("mbti"));
        dto.setFree(rs.getString("free"));
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

  // 하나의 데이터만 조회(디테일페이지, 수정폼 띄우기)
  public IntroDto getOneIntro(String num) {
    IntroDto dto = new IntroDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from intro where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      rs = pstmt.executeQuery();

      while (rs.next()) {

        dto.setNum(rs.getString("num"));
        dto.setName(rs.getString("name"));
        dto.setBirthday(rs.getString("birthday"));
        dto.setHp(rs.getString("hp"));
        dto.setHometown(rs.getString("hometown"));
        dto.setHobby(rs.getString("hobby"));
        dto.setMbti(rs.getString("mbti"));
        dto.setFree(rs.getString("free"));
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

  // insert
  public void insertIntro(IntroDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into intro values(null,?,?,?,?,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getBirthday());
      pstmt.setString(3, dto.getHp());
      pstmt.setString(4, dto.getHometown());
      pstmt.setString(5, dto.getHobby());
      pstmt.setString(6, dto.getMbti());
      pstmt.setString(7, dto.getFree());

      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public void updateIntro(IntroDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql =
        "update intro set name=?, birthday=?, hp=?, hometown=?,hobby=?,mbti=?,free=? where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getBirthday());
      pstmt.setString(3, dto.getHp());
      pstmt.setString(4, dto.getHometown());
      pstmt.setString(5, dto.getHobby());
      pstmt.setString(6, dto.getMbti());
      pstmt.setString(7, dto.getFree());
      pstmt.setString(8, dto.getNum());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // delete
  public void deleteIntro(String num) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "delete from intro where num=" + num;

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

}
