package day1031_1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingBasic extends JFrame{

	//변수
	Container cp;
	JButton btn1;	
	JButton btn2;	
	JButton btn3;	
	JButton btn4;	
	JButton btn5;	
	
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
		btn2=new JButton("버튼2");
		btn3=new JButton("버튼3");
		btn4=new JButton("버튼4");
		btn5=new JButton("버튼5");
		
		//프레임에 버튼 추가 - BorderLayout이 기본
		this.add("North",btn1); //첫글자 대문자
		this.add("South",btn2);
		this.add("East",btn3);
		this.add("West",btn4);
		this.add("Center",btn5);
		
		//버튼 1에 속성
		btn1.setBackground(Color.pink);
		btn1.setForeground(Color.yellow);
		btn1.setSize(30,30);
		btn2.setBackground(Color.pink);
		btn2.setForeground(Color.yellow);
		btn2.setSize(40,50);
		btn3.setBackground(Color.pink);
		btn3.setForeground(Color.yellow);
		btn3.setSize(30,20);
		btn4.setBackground(Color.pink);
		btn4.setForeground(Color.yellow);
		btn4.setSize(40,40);
		btn5.setBackground(Color.pink);
		btn5.setForeground(Color.yellow);
		btn5.setSize(20,50);

	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new SwingBasic("SwingBasic 학습");


	}
}
