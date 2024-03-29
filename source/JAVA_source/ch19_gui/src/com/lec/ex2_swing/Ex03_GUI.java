package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_GUI extends JFrame implements ActionListener {
	// 컴포넌트 객체 변수 선언, ArrayList 변수,file io를 위한 stream, DB 접속관련 변수
	private Container   contenPane; // 컨테이너 얻어올 변수
	private JPanel      jp; // 이름,전화,나이 받을 6개 컴포넌트를 gridLayout으로 add
	private JTextField  txtName, txtTel, txtAge;
	private ImageIcon   icon;
	private JButton     btn;
	private JTextArea   jta;
	private JScrollPane scrollbar;
	private int         cnt; // 몇명 입력했는지 저장
	
	// 생성자 : 컨테이너 얻어와서-> SetLayout -> 컴포넌트 객체 생성 후 add -> event 추가
	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		//contenPane.setLayout(new BorderLayout()); 기본 레이아웃 그대로 사용해서 생략
		jp = new JPanel(new GridLayout(3, 2));
		//jp.setLayout(new GridLayout(3, 2)); // 패널의 기본 레이아웃은 flowLayout
		txtName = new JTextField(); // gridLayout은 자동 공간확보
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("src/Icon/output.png");
		btn = new JButton("출력", icon);
		jta = new JTextArea(5, 30); // 5행 30열 txtArea
		scrollbar =  new JScrollPane(jta);
		jp.add(new JLabel("이  름", (int) CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("전  화", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("나  이", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btn, BorderLayout.CENTER);
		contenPane.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(500,500);
		setBounds(500, 500, 400, 300);
		//이벤트 추가
		btn.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if(e.getSource() == btn) {
			// txtName, txtTel, txtAge 에 입력된 값을 jta에 출력
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항");
				return;
			}
			if(tel.indexOf("-") == tel.lastIndexOf("-") || 
				tel.indexOf("-")<2 ||
				tel.lastIndexOf("-")>10) {
				System.out.println("전화번호 형식을 확인해주세요");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age > 150) {
					System.out.println("유효하지 않는 나이를 입력하셨습니다.");
					age = 0;
				}
			} catch (Exception e2) {
				System.out.println("유효하지 않는 나이를 입력하셨습니다.");
			}
			System.out.println(++cnt + "명 입력됨");
			if(cnt == 1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age+"\n"); // 한명 add한 것을 jta출력
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
	}
	public static void main(String[] args) {
		new Ex03_GUI("진우!");
	}
}
