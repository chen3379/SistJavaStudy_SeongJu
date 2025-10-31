package day1031_1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingBasic extends JFrame{

	//변수
	Container cp;
	JButton btn1;	
	
	//생성
	public SwingBasic(String title) {
		
		super(title);
		
		cp=getContentPane();
		
		//여기서 this는 JFrame을 의미
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫는 역할
		this.setBounds(200, 100, 400, 300); //창 크기 지정 
		cp.setBackground(new Color(180, 160, 170)); //RGB값 지정
		this.setVisible(true); //가시성 지정
		
		//this.getContentPane().setBackground(new Color(80,70,60)); - cp를 따로 선언 안 하고 this.로도 바로 사용은 가능하다
		
		//버튼 생성
		btn1=new JButton("버튼1");
		
		//프레임에 버튼 추가 - BorderLayout이 기본
		this.add("North",btn1); //첫글자 대문자
		this.add("South",new JButton("남쪽"));
		this.add("East",new JButton("동쪽"));
		this.add("West",new JButton("서쪽"));
		this.add("Center",new JButton("중앙"));
		
		//버튼 1에 속성
		btn1.setBackground(Color.pink);
		btn1.setForeground(Color.yellow);

	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new SwingBasic("SwingBasic 학습");


	}
}
