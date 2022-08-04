package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Ex02 extends JFrame implements ActionListener{
	// 필요한 컴포넌트 변수 추가
	//private JPanel jpanel; // 컨테이너 얻어올 변수
	private Container contenPane; // 컨테이너 얻어올 변수
	private ImageIcon icon; // 버튼에 들어갈 icon
	private JButton jBtn; 
	private JTextField jtxtField;
	private Vector<String> items; // 콤보박스에 들어갈 item리스트 (item이 가변적일때는 Vector, 고정적일때 String배열)
	private String[] item = {"A", "B", "C"};
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; // 빈 라벨
	private JButton jBtnExit;
	
	// 생성자 : 컨테이너 얻어와서 layout 셋팅 -> 컴포넌트 생성 후 add -> setVisible, setSize(화면구현)  -> event 추가
	public Ex02(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x클릭시 종료
		contenPane = getContentPane(); // swing은 컨테이너를 받아온 후 작업
		contenPane.setLayout(new FlowLayout()); // 지정하지 않으면 BorderLayout()
		icon = new ImageIcon("src/Icon/write.gif");
		jBtn = new JButton("Button", icon);
		jtxtField = new JTextField(20);
		//jCombo = new JComboBox<String>(item); // 콤보박스 item 리스트 추가 방법 1. String 배열(고정)
		items = new Vector<String>();
		// items 추가할 사항을 가져오기
		items.add("A"); items.add("B"); items.add("C");
		jCombo = new JComboBox<String>(items); // 콤보박스 item 리스트 추가방법 2. vector 이용(가변적)
		jCheck = new JCheckBox("Check");
		jlBlank = new JLabel("");
		jBtnExit = new JButton("Exit");
		
		// 컴포넌트 add -> 컴포넌트 사이즈 조정(pdf참조)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit);
		jBtn.setPreferredSize(new Dimension(200,50));
		jtxtField.setPreferredSize(new Dimension(300,50));
		jCombo.setPreferredSize(new Dimension(100,50));
		jCheck.setPreferredSize(new Dimension(100,50));
		jlBlank.setPreferredSize(new Dimension(200,50));
		jBtnExit.setPreferredSize(new Dimension(100,50));
		setVisible(true);
		pack();
		setLocation(500,500);
		//  event Listener 추가
		jBtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // event 로직
		if(e.getSource() == jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if(temp.equals("")) {
				System.out.println("이놈"); // jtxtField에 빈스트링이거나 space만 입력했을 경우
				return;
			}
			jCombo.addItem(temp); // 콤보박스에 item 추가(=items 벡터에 추가)
			jlBlank.setText(jtxtField.getText().trim()); // jlBlank 에는 jtxtField 입력내용 그대로(대문자로 바꾸기 전)
			jtxtField.setText("");
		}else if(e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString(); // 콤보박스 선택된 항목 "A", "B", ......
			int no = jCombo.getSelectedIndex();
			jlBlank.setText(no+1 + "번째" + temp +" 선택");
			jCombo.setSelectedItem("A"); // "A"가 선택되도록 = jCombo.setSelectedIndex(0);
		}else if(e.getSource() == jCheck) {
			if(jCheck.isSelected()) { // 체크박스 체크됨
				jlBlank.setText(jCheck.getText());
			}else { //체크박스 언체크
				jlBlank.setText("");
			}
		}else if(e.getSource() == jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex02("입력"); // 실행
	}

}
