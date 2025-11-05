package day1104;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent extends JFrame implements ActionListener{
	
	//변수
		Container cp;
		JButton btn1;	
		JButton btn2;	
		JButton btn3;	
//		JButton btn4;	
//		JButton btn5;	
		
		//생성
		public SwingEvent(String title) {
			
			super(title);
			
			cp=getContentPane();
			
			//여기서 this는 JFrame을 의미
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫는 역할
			this.setBounds(200, 100, 400, 300); //창 크기 지정 
			cp.setBackground(new Color(255, 127, 80)); //RGB값 지정
			
			initDesign();
			
			this.setVisible(true); //가시성 지정
		}
		
		//디자인
		public void initDesign() {
			
			//기본디자인은 BorderLayout 이므로 FlowLayout으로 변경 시 레이아웃 변경
			this.setLayout(new FlowLayout());
			
			//버튼생성
			btn1=new JButton("배경색을 CYAN로 변경");
			btn2=new JButton("배경색을 white로 변경");
			btn3=new JButton("배경색을 red로 변경");
			
			//프레임에 추가
			this.add(btn1);
			this.add(btn2);
			this.add(btn3);
			
			//btn1, btn2에 이벤트 부여 선언
			btn1.addActionListener(this);
			btn2.addActionListener(this);
			btn3.addActionListener(this);
			
		}
		
		public static void main(String[] args) {
			new SwingEvent("SwingEvent 연습"); //참조변수 필요X
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object ob=e.getSource();
			if(ob==btn1)
				//배경색 변경
				cp.setBackground(Color.CYAN);
			if(ob==btn2)
				cp.setBackground(Color.white);
			if(ob==btn3)
				cp.setBackground(Color.red);
			
		}

}
