package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login extends Frame{
	private Label lbl1;
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	public Ex02Login(String title) { // Frame�� ������Ʈ �߰��ϰ� ȭ�餱 ���̰� -> event
		super(title);
		// Frame�� ���̾ƿ� Ÿ�� : BorderLayout (��, ��, ��, ��, CENTER) �⺻��
		//                    FlowLayout (���ʺ��� ����������, ������ �Ʒ��� �������� add)
		//                    GridLayout (����)
		setLayout(new FlowLayout()); // Frame�� ���̾ƿ� ����
		lbl1 = new Label("���̵�");
		txtId = new TextField(20);
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("�α���");
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		setSize(new Dimension(300, 150));
		setLocation(500,500);
		setVisible(true);
		setResizable(false);
		// xŬ���� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // �Ⱥ��̰�
				dispose();         // �ڿ� ��ü
				System.exit(0);    // ��������
			}
		});
	}
	public Ex02Login() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02Login("Login");
	}
}
