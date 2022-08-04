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
	
	public Ex03() { // Layout����, ������Ʈ ���� �� add, setVisitble, setSize
		// setLayout(new BorderLayout()); Frame�� �⺻ ���̾ƿ��� Border�̹Ƿ� ����
		panel = new Panel();
//		panel = new Panel(new FlowLayout()); panel�� �⺻ ���̾ƿ��� Flow�̹Ƿ� ����
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
		// xŬ���� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // �Ⱥ��̰�
				dispose();         // �ڿ� ��ü
				System.exit(0);    // ��������
			}
		});
		// �̺�Ʈ �߰� 1. implements ActionListener -> override
		// 		   2. �̺�Ʈ ������ �߰� (V)
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		//         3. override�� �޼ҵ� �ȿ� �����߰�
	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnOk) { // OK��ư Ŭ���� �� ���� : txtfield�� �ؽ�Ʈ�� list �߰�
			list.add(txtField.getText().trim());
			txtField.setText("");
		}else if(e.getSource() == btnExit) { // ���� ����
			setVisible(false); // �Ⱥ��̰�
			dispose();         // �ڿ� ��ü
			System.exit(0);    // ��������
		}
	}
	public static void main(String[] args) {
		new Ex03("gogo");
	}
}
