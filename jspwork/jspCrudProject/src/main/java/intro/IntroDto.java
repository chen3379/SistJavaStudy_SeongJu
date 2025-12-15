package intro;

import java.sql.Timestamp;

public class IntroDto {

    private String num;
    private String name;
    private String birthday;
    private String hp;
    private String hometown;
    private String hobby;
    private String mbti;
    private String free;
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

    public String getBirthday() {
	return birthday;
    }

    public void setBirthday(String birthday) {
	this.birthday = birthday;
    }

    public String getHp() {
	return hp;
    }

    public void setHp(String hp) {
	this.hp = hp;
    }

    public String getHometown() {
	return hometown;
    }

    public void setHometown(String hometown) {
	this.hometown = hometown;
    }

    public String getHobby() {
	return hobby;
    }

    public void setHobby(String hobby) {
	this.hobby = hobby;
    }

    public String getMbti() {
	return mbti;
    }

    public void setMbti(String mbti) {
	this.mbti = mbti;
    }

    public String getFree() {
	return free;
    }

    public void setFree(String free) {
	this.free = free;
    }

    public Timestamp getWriteday() {
	return writeday;
    }

    public void setWriteday(Timestamp writeday) {
	this.writeday = writeday;
    }

}
