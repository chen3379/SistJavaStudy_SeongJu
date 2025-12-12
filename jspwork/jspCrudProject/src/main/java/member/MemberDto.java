package member;

import java.sql.Timestamp;

public class MemberDto {

    private String num;
    private String name;
    private String hp;
    private String driver;
    private String job;
    private Timestamp writeday;

    public String getNum() {
	return num;
    }

    public void setNum(String num) {
	this.num = num;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getHp() {
	return hp;
    }

    public void setHp(String hp) {
	this.hp = hp;
    }

    public String getDriver() {
	return driver;
    }

    public void setDriver(String driver) {
	this.driver = driver;
    }

    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    public Timestamp getWriteday() {
	return writeday;
    }

    public void setWriteday(Timestamp writeday) {
	this.writeday = writeday;
    }

}
