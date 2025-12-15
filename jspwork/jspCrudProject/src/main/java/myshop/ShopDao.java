package myshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DBConnect;

public class ShopDao {

  DBConnect db = new DBConnect();

  // insert
  public void insertDao(ShopDto dto) {

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into myshop values(null,?,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getSangpum());
      pstmt.setString(2, dto.getPhoto());
      pstmt.setString(3, dto.getPrice());
      pstmt.setString(4, dto.getIpgoday());

      pstmt.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }


  // select
  // 전체목록
  public List<ShopDto> selectAll() {
    List<ShopDto> list = new Vector<ShopDto>();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myshop order by num";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ShopDto dto = new ShopDto();
        dto.setNum(rs.getString("num"));
        dto.setSangpum(rs.getString("sangpum"));
        dto.setPhoto(rs.getString("photo"));
        dto.setPrice(rs.getString("price"));
        dto.setIpgoday(rs.getString("ipgoday"));
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

  // 하나의 데이터.. 1.디테일페이지 2.수정폼
  public ShopDto getOneData(String num) {
    ShopDto dto = new ShopDto();

    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from myshop where num=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      rs = pstmt.executeQuery();


      while (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setSangpum(rs.getString("sangpum"));
        dto.setPhoto(rs.getString("photo"));
        dto.setPrice(rs.getString("price"));
        dto.setIpgoday(rs.getString("ipgoday"));
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

}
