package memguest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mysql.db.DBConnect;

public class MemGuestDao {
  DBConnect db = new DBConnect();

  public void insertGuest(MemGuestDto dto) {
    Connection conn = db.getDBConnect();
    PreparedStatement pstmt = null;

    String sql = "insert into memguest values(null,?,?,?,now())";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getMyid());
      pstmt.setString(2, dto.getPhoto());
      pstmt.setString(3, dto.getContent());

      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }

  }

}
