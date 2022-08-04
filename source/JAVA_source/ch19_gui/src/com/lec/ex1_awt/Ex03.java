package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {
	
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;
	
	public Ex03() { // Layout셋팅, 컴포넌트 생성 후 add, setVisitble, setSize
		// setLayout(new BorderLayout()); Frame의 기본 레이아웃이 Border이므로 생략
		panel = new Panel();
//		panel = new Panel(new FlowLayout()); panel의 기본 레이아웃이 Flow이므로 생략
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit =  new Button("Exit");
		list = new List();
		
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 50);
		// x클릭시 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게
				dispose();         // 자원 해체
				System.exit(0);    // 강제종료
			}
		});
		// 이벤트 추가 1. implements ActionListener -> override
		// 		   2. 이벤트 리스너 추가 (V)
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		//         3. override된 메소드 안에 로직추가
	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnOk) { // OK버튼 클릭시 할 로직 : txtfield의 텍스트를 list 추가
			list.add(txtField.getText().trim());
			txtField.setText("");
		}else if(e.getSource() == btnExit) { // 종료 로직
			setVisible(false); // 안보이게
			dispose();         // 자원 해체
			System.exit(0);    // 강제종료
		}
	}
	public static void main(String[] args) {
		new Ex03("gogo");
	}
}
