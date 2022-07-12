package com.lec.exam;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class CustomerMng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JTextArea jta;
	private JScrollPane scrollbar;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private ArrayList<CustomerDto> customers;
	private CustomerDao dao = CustomerDao.getInstance();
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// �����̳� ������
		contenPane = getContentPane();
		// �����̳� ���̾ƿ� ����
		contenPane.setLayout(new FlowLayout());
		// ������Ʈ ����
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
				
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		jta = new JTextArea(15,30);
		scrollbar = new JScrollPane(jta);
		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
		// jpup�� add
		jpup.add(new JLabel("����ȣ",(int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("��  ��",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ",(int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		// jpdown�� add (��ư�� 4)
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		// contenPane�� add
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollbar);
		setSize(new Dimension(400, 450));
		setLocation(2200, 100);
		setResizable(false);
		setVisible(true);
		// �̺�Ʈ ������ �߰�
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) {	
			String phone, name; int point=1000;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			try {
				point = Integer.parseInt(txtPhone.getText().trim());
			}catch (Exception e1) { }
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");
			if(phone.length()<11 || name.length()<2 ||
					preIdx==postIdx) { // ��ȭ��ȣ�� '-'�� ���ų� �ϳ��� ���
				jta.setText("��ȿ�� ���� �Է��ϼ���");
				return;
			}
			//����
			CustomerDto newCustomer = new CustomerDto(phone, name, point);
			int result = dao.insertCustomer(newCustomer);
			jta.setText(result==CustomerDao.SUCCESS? name+"�� ���Լ���":"���Խ���");
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("1000");
		}else if(e.getSource() == btnSearch) {
			txtName.setText("");
			txtPoint.setText("");
			// ����4�ڸ���ȸ(Ǯ ��ȭ��ȣ ��ȸ)
			String searchPhone = txtPhone.getText().trim();
			if(searchPhone.length()<4) {
				jta.setText("����ȣ�� 4�ڸ� �̻� �Է��ϼž� �մϴ�");
				return;
			}
			customers = dao.selectPhone(searchPhone);
			if(customers.size()==1) {
				String phone = customers.get(0).getPhone();
				String name  = customers.get(0).getName();
				int point    = customers.get(0).getPoint();
				txtPhone.setText(phone);
				txtName.setText(name);
				txtPoint.setText(String.valueOf(point));//int�� ���ڿ��� �ٲ㼭 setText��
			}else if(customers.size()>1) {
				jta.setText("��ȣ.�̸�\t��ȭ\t����Ʈ\n");
				for(CustomerDto customer : customers) {
					jta.append(customer.toString()+"\n");
				}
			}else {
				jta.setText("�˻����� �ʴ� ��ȭ��ȣ�Դϴ�");
			}
		}else if(e.getSource() == btnOutput) {
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			customers = dao.selectAll();
			if(customers.size()==0) {
				jta.append("��ϵ� ȸ���� �����ϴ�");
			}else {
				jta.setText("��ȣ.�̸�\t��ȭ\t����Ʈ\n");
				for(CustomerDto customer : customers) {
					jta.append(customer.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}//if
	}//actionPerformed
	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}
}
