package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01_Thursday extends JFrame implements ActionListener{
	
	private JPanel panel; // 받아온 컨테이너 저장 
	// private Container contenPane; // 받아온 컨테이너 저장
	private JButton jbtn;
	private JLabel jlbl;
	
	public Ex01_Thursday(String title) { // 컨테이너 받아와서 컴포넌트 add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 누르면 종료
		// swing 은 컨테이너 얻어오기(맨처음)
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		jbtn = new JButton("Exit");
		jlbl =(new JLabel("이진우", (int) CENTER_ALIGNMENT));
		
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150,200));
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200));
		setVisible(true);
		setSize(new Dimension(400, 250));
		setLocation(700,300);
		// 이벤트 리스너 추가
		jbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if(e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Ex01_Thursday("하하");
	}
}
