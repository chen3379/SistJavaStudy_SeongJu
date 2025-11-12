package day1110;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAnonymous extends JFrame {

	Container cp;
	JButton btnAdd, btnSub, btnMultiply, btnDivide;
	JLabel lblResult;

	public SwingAnonymous(String title) {

		super(title);

		cp = getContentPane();

		// 여기서 this는 JFrame을 의미
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫는 역할
		this.setBounds(200, 100, 500, 400); // 창 크기 지정
		cp.setBackground(new Color(190, 187, 80)); // RGB값 지정

		initDesign();

		this.setVisible(true); // 가시성 지정
	}

	public void initDesign() {

		// default는 보더레이아웃
		// 자유롭게 레이아웃 변경하려면 null
		this.setLayout(null);

		JLabel lbl1 = new JLabel("숫자1");
		JLabel lbl2 = new JLabel("숫자2");
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		btnAdd = new JButton("더하기");
		btnSub = new JButton("빼기");
		btnMultiply = new JButton("곱하기");
		btnDivide = new JButton("나누기");
		lblResult = new JLabel("결과 나오는 곳");

		lbl1.setBounds(100, 50, 80, 30);
		lbl2.setBounds(100, 100, 80, 30);
		tf1.setBounds(200, 50, 100, 30);
		tf2.setBounds(200, 100, 100, 30);
		lblResult.setBounds(100, 250, 500, 30);
		btnAdd.setBounds(100, 200, 70, 30);
		btnSub.setBounds(190, 200, 70, 30);
		btnMultiply.setBounds(280, 200, 70, 30);
		btnDivide.setBounds(370, 200, 70, 30);

		// 글꼴변경
		lblResult.setFont(new Font("", Font.BOLD, 18));

		this.add(lbl1);
		this.add(lbl2);
		this.add(tf1);
		this.add(tf2);
		this.add(btnAdd);
		this.add(lblResult);
		this.add(btnSub);
		this.add(btnMultiply);
		this.add(btnDivide);

		// 익명내부클래스 형식으로 만들기
		// 버튼이벤트..더하기
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int t1 = Integer.parseInt(tf1.getText());
				int t2 = Integer.parseInt(tf2.getText());
				int sum = t1 + t2;

				// lblResult에 출력
				String result = "계산결과: " + t1 + "+" + t2 + "=" + sum;
				// 라벨에 결과 출력
				lblResult.setText(result);
			}
		});

		// 버튼이벤트..빼기
		btnSub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int t1 = Integer.parseInt(tf1.getText());
				int t2 = Integer.parseInt(tf2.getText());

				int sub = t1 - t2;

				// lblResult에 출력
				String result = "계산결과: " + t1 + "-" + t2 + "=" + sub;
				// 라벨에 결과 출력
				lblResult.setText(result);
			}
		});

		// 버튼이벤트..곱하기
		btnMultiply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int t1 = Integer.parseInt(tf1.getText());
				int t2 = Integer.parseInt(tf2.getText());

				int multiply = t1 * t2;

				// lblResult에 출력
				String result = "계산결과: " + t1 + "X" + t2 + "=" + multiply;
				// 라벨에 결과 출력
				lblResult.setText(result);
			}
		});

		// 버튼이벤트..나누기
		btnDivide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int t1 = Integer.parseInt(tf1.getText());
				int t2 = Integer.parseInt(tf2.getText());

				int divide = t1 / t2;

				// lblResult에 출력
				String result = "계산결과: " + t1 + "/" + t2 + "=" + divide;
				// 라벨에 결과 출력
				lblResult.setText(result);
			}
		});

	}

	public static void main(String[] args) {
		new SwingAnonymous("학생내부클래스 이용하여 이벤트");
	}
}
