package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01_Thursday extends JFrame implements ActionListener{
	
	private JPanel panel; // �޾ƿ� �����̳� ���� 
	// private Container contenPane; // �޾ƿ� �����̳� ����
	private JButton jbtn;
	private JLabel jlbl;
	
	public Ex01_Thursday(String title) { // �����̳� �޾ƿͼ� ������Ʈ add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư ������ ����
		// swing �� �����̳� ������(��ó��)
		panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		jbtn = new JButton("Exit");
		jlbl =(new JLabel("������", (int) CENTER_ALIGNMENT));
		
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150,200));
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200));
		setVisible(true);
		setSize(new Dimension(400, 250));
		setLocation(700,300);
		// �̺�Ʈ ������ �߰�
		jbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ����
		if(e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Ex01_Thursday("����");
	}
}
