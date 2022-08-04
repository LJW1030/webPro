package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

	private Container contenPane;
	private JPanel jp;
	private JPanel jp2;
	private JTextField name;
	private JTextField tel;
	private JTextField age;
	private ImageIcon icon;
	private ImageIcon icon2;
	private JButton btnIn;
	private JButton btnOut;
	ArrayList<Person> arr = new ArrayList<Person>();

	public MyFrame(JTextField name, JTextField tel, JTextField age) throws HeadlessException {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp = new JPanel(new GridLayout(3, 2));
		name = new JTextField();
		tel = new JTextField();
		age = new JTextField();
		jp2 = new JPanel();
		icon = new ImageIcon("src/icon/join.png");
		icon2 = new ImageIcon("src/icon/output.png");
		btnIn = new JButton("입력", icon);
		btnOut = new JButton("출력", icon2);

		jp.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jp.add(name);
		jp.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jp.add(tel);
		jp.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jp.add(age);
		jp2.add(btnIn);
		jp2.add(btnOut);

		contenPane.add(jp, BorderLayout.CENTER);
		contenPane.add(jp2, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(300, 200));
		setLocation(500, 500);

		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String n = null;
		String t = null;
		int a = 0;
		if (e.getSource() == btnIn) {
			n = name.getText().trim();
			t = tel.getText().trim();
			if (n.equals("") || t.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력");
				return;
			}
			if (t.indexOf("-") == t.lastIndexOf("-") || t.indexOf("-") < 2 || t.lastIndexOf("-") > 10) {
				System.out.println("유효하지않는 전화번호 입니다.");
				return;
			}
			try {
				a = Integer.parseInt(age.getText());
				if (a < 0 || a > 130) {
					System.out.println("유효하지 않은 나이이므로 0으로 표기");
					a = 0;
				}
			} catch (Exception e2) {
				System.out.println("유효하지 않은 나이 입니다.");
			}
//			name.setText("");
//			tel.setText("");
//			age.setText("");
			arr.add(new Person(n, t, a));
			System.out.println(arr);
		} else if (e.getSource() == btnOut) {
			OutputStream os = null;
			try {
				os = new FileOutputStream("D:/webPro/source/01_java/ch19_gui/src/com/lec/ex2_swing/person.txt");
				for(Person p : arr) {
					os.write( (p.toString()+"\n").getBytes());
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame("진우");
	}
}
