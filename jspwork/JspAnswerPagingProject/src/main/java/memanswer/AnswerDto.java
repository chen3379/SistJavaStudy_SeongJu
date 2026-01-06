package memanswer;

import java.sql.Timestamp;

public class AnswerDto {

  private String idx;
  private String num;
  private String myid;
  private String memo;
  private Timestamp writeday;

  public String getIdx() {
    return idx;
  }

  public void setIdx(String idx) {
    this.idx = idx;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getMyid() {
    return myid;
  }

  public void setMyid(String myid) {
    this.myid = myid;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Timestamp getWriteday() {
    return writeday;
  }

  public void setWriteday(Timestamp writeday) {
    this.writeday = writeday;
  }

}
