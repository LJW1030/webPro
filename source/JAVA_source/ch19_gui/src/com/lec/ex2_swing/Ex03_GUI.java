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
	// ������Ʈ ��ü ���� ����, ArrayList ����,file io�� ���� stream, DB ���Ӱ��� ����
	private Container   contenPane; // �����̳� ���� ����
	private JPanel      jp; // �̸�,��ȭ,���� ���� 6�� ������Ʈ�� gridLayout���� add
	private JTextField  txtName, txtTel, txtAge;
	private ImageIcon   icon;
	private JButton     btn;
	private JTextArea   jta;
	private JScrollPane scrollbar;
	private int         cnt; // ��� �Է��ߴ��� ����
	
	// ������ : �����̳� ���ͼ�-> SetLayout -> ������Ʈ ��ü ���� �� add -> event �߰�
	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		//contenPane.setLayout(new BorderLayout()); �⺻ ���̾ƿ� �״�� ����ؼ� ����
		jp = new JPanel(new GridLayout(3, 2));
		//jp.setLayout(new GridLayout(3, 2)); // �г��� �⺻ ���̾ƿ��� flowLayout
		txtName = new JTextField(); // gridLayout�� �ڵ� ����Ȯ��
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("src/Icon/output.png");
		btn = new JButton("���", icon);
		jta = new JTextArea(5, 30); // 5�� 30�� txtArea
		scrollbar =  new JScrollPane(jta);
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btn, BorderLayout.CENTER);
		contenPane.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(500,500);
		setBounds(500, 500, 400, 300);
		//�̺�Ʈ �߰�
		btn.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ����
		if(e.getSource() == btn) {
			// txtName, txtTel, txtAge �� �Էµ� ���� jta�� ���
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� ����");
				return;
			}
			if(tel.indexOf("-") == tel.lastIndexOf("-") || 
				tel.indexOf("-")<2 ||
				tel.lastIndexOf("-")>10) {
				System.out.println("��ȭ��ȣ ������ Ȯ�����ּ���");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age > 150) {
					System.out.println("��ȿ���� �ʴ� ���̸� �Է��ϼ̽��ϴ�.");
					age = 0;
				}
			} catch (Exception e2) {
				System.out.println("��ȿ���� �ʴ� ���̸� �Է��ϼ̽��ϴ�.");
			}
			System.out.println(++cnt + "�� �Էµ�");
			if(cnt == 1) {
				jta.setText("�̸�\t��ȭ\t\t����\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age+"\n"); // �Ѹ� add�� ���� jta���
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
	}
	public static void main(String[] args) {
		new Ex03_GUI("����!");
	}
}
