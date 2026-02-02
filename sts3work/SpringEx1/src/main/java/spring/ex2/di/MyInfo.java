package spring.ex2.di;

public class MyInfo {

	String name;
	int age;
	String addr;
	
	//»ý¼ºÀÚ
	public MyInfo(String name,int age,String addr) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.addr=addr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MyInfo[name="+name+", age="+age+", addr="+addr+"]";
	}
}
