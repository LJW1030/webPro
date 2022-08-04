package com.lec.ex4_supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class SuperMng extends JFrame implements ActionListener {
	// DAO
	CustomerDao dao = CustomerDao.getInstance();
	//ȭ�鱸��
	private Container container;
	private  JPanel jpup, jpbtn;
	private JTextField txtcid, txtctel, txtcname, txtcpoint, txtcamount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btncidsearch, btnctelsearch, btncnamesearch, btnbuywithpoint;
	private JButton btnbuy, btnlevelnameoutput, btnalloutput, btninsert, btnctelupdate, btndelete, btnexit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;
	public SuperMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������Ʈ ��ü ����
		// �����̳ʿ� ������Ʈ ��ġ
		// �̺�Ʈ �߰�
		container = getContentPane(); // �����̳ʴ� �⺻ borderlayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6,3)); // �г��� �⺻ flowlayout
		jpbtn = new JPanel();
		txtcid = new JTextField(20);
		txtctel = new JTextField(20);
		txtcname = new JTextField(20);
		txtcpoint = new JTextField(20);
		txtcamount = new JTextField(20);
		levelNames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);
		btncidsearch = new JButton("���̵� �˻�");
		btnctelsearch = new JButton("��4�ڸ�(FULL) �˻�");
		btncnamesearch = new JButton("�� �̸� �˻�");
		btnbuywithpoint = new JButton("����Ʈ�θ� ����");
		btnbuy = new JButton("��ǰ ����");
		btnlevelnameoutput = new JButton("��޺� ���");
		btnalloutput = new JButton("��ü ���");
		btninsert = new JButton("ȸ�� ����");
		btnctelupdate = new JButton("��ȣ����");
		btndelete = new JButton("ȸ�� Ż��");
		btnexit = new JButton("������");
		txtpool = new JTextArea(6,70);
		scrollpane = new JScrollPane(txtpool);
		// �����̳ʿ� ��ġ
		jpup.add(new JLabel("���̵�",(int) CENTER_ALIGNMENT));
		jpup.add(txtcid);
		jpup.add(btncidsearch);
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtctel);
		jpup.add(btnctelsearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtcname);
		jpup.add(btncnamesearch);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtcpoint);
		jpup.add(btnbuywithpoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtcamount);
		jpup.add(new JLabel()); // 5�� 3�� �� ��
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnbuy);
		jpbtn.add(btnlevelnameoutput);
		jpbtn.add(btnalloutput);
		jpbtn.add(btninsert);
		jpbtn.add(btnctelupdate);
		jpbtn.add(btndelete);
		jpbtn.add(btnexit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollpane);
		setVisible(true);
		setSize(new Dimension(800,400));
		setLocation(500,500);
		txtpool.setText("\t�ڡڡڰ��˻� �� �����ϼ���ڡڡ�");
		//�̺�Ʈ �߰�
		btncidsearch.addActionListener(this);
		btnctelsearch.addActionListener(this);
		btncnamesearch.addActionListener(this);
		btnbuywithpoint.addActionListener(this);
		btnbuy.addActionListener(this);
		btnlevelnameoutput.addActionListener(this);
		btnalloutput.addActionListener(this);
		btninsert.addActionListener(this);
		btnctelupdate.addActionListener(this);
		btndelete.addActionListener(this);
		btnexit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btncidsearch) { // ���̵� �˻� ----------------------------------------------------------------
			int cid;
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� �� ID�� �Է��Ͻ��� �˻��ϼ���");
				return;
			} // try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if(customer!=null) {
				//txtcid.setText(String.valueOf(customer.getCid()));
				txtctel.setText(customer.getCtel());
				txtcname.setText(customer.getCname());
				txtcpoint.setText(String.valueOf(customer.getCpoint()));
				txtcamount.setText(""); // ��ǰ���ž� ���� ����
				comLevelName.setSelectedItem(customer.getLevelName());
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������������ �߰����ž�\n");
				txtpool.append("------------------------------------------------------------\n");
				txtpool.append(customer.toString());
			}else {
				txtpool.setText("�˻����� ���� ID�Դϴ�");
			}
		}else if(e.getSource()==btnctelsearch) { // ��4�ڸ� �˻�-----------------------------------------------------------------
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String ctel = txtctel.getText().trim();
			if (ctel.length()<4) {
				txtpool.setText("4�ڸ� �̻��� ��ȣ�� �Է��Ͻÿ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);
			if(customers.size()!=0) {
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������������ �߰����ž�\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtcid.setText(String.valueOf(c.getCid()));
					txtcname.setText(c.getCname());
					txtctel.setText(c.getCtel());
					txtcpoint.setText(String.valueOf(c.getCpoint()));
					txtcamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(c.getLevelName());
					txtpool.append(c.toString()+"\n");
				}
			}else {
				txtpool.setText("�ش� ��ȣ�� ���� �����ϴ�");
			}
		}else if(e.getSource()==btncnamesearch) { // �̸� �˻�---------------------------------------------------------------------
			// cname �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtcid.setText("");
			txtctel.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String cname = txtcname.getText().trim();
			if (cname.length()<2) {
				txtpool.setText("�α��� �̻��� �̸��� �Է��Ͻÿ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);
			if(customers.size()!=0) {
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������������ �߰����ž�\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtcid.setText(String.valueOf(c.getCid()));
					txtcname.setText(c.getCname());
					txtctel.setText(c.getCtel());
					txtcpoint.setText(String.valueOf(c.getCpoint()));
					txtcamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(c.getLevelName());
					txtpool.append(c.toString()+"\n");
				}
			}else {
				txtpool.setText("�ش� �̸��� ���� �����ϴ�");
			}
		}else if(e.getSource()==btnbuywithpoint) { // ����Ʈ ����---------------------------------------------------------------------
			int cid, cpoint, camount;
			try {
				 cid = Integer.parseInt(txtcid.getText().trim());
				 cpoint = Integer.parseInt(txtcpoint.getText().trim());
				 camount = Integer.parseInt(txtcamount.getText().trim());
				 if(cpoint < camount) {
					 txtpool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���Ű� �Ұ��մϴ�");
					 return;
				 } 
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� ��ID�� point�� ���űݾ��� �Է��Ͻ� �� �����ϼ���");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("����Ʈ ���ż���");
				txtcpoint.setText(String.valueOf(cpoint-camount)); // ������ ����Ʈ�� ����
				txtcamount.setText("");
			}else {
				txtpool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ���Źٶ��ϴ�");
			}
		}else if(e.getSource()==btnbuy) { // ��ǰ����--------------------------------------------------------------------------------
			int cid, camount, cpoint;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� ��ID�� ���űݾ��� �Է��Ͻð� �����ϼ���");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("��ǰ ���� �Ϸ�");
				txtcpoint.setText(String.valueOf(cpoint+(int)(camount*0.05)));
				txtcamount.setText("");
			}else {
				txtpool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�, �� �˻��� �����ϼ���");
			}
		}else if(e.getSource()==btnlevelnameoutput) { // ��޺� ���-------------------------------------------------------------------
			// levelName �Է� �޺��ڽ� �ܿ��� �⺻���� ������� ���� ����
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			// comLevelName.setSelectedIndex(0);
			String levelName = comLevelName.getSelectedItem().toString();
			if (levelName.length()==0) {
				txtpool.setText("���ϴ� ����� �����Ͻð� �˻��Ͻÿ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) {
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������������ �߰����ž�\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtpool.append(c.toString()+"\n");
				}
				txtpool.append("��"+customers.size()+"��");
			}else {
				txtpool.setText("�ش� ������ ���� �����ϴ�");
			}
		}else if(e.getSource()==btnalloutput) { // ��ü���----------------------------------------------------------------------------
			// ��� �Է� ������Ʈ�� ������� ���� ����
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");;
			ArrayList<CustomerDto> customers = dao.getCustmoers();
			if(customers.size()!=0) {
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t������������ �߰����ž�\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtpool.append(c.toString()+"\n");
				}
				txtpool.append("��"+customers.size()+"��");
			}else {
				txtpool.setText("��ϵ� ���� �����ϴ�");
			}
		}else if(e.getSource()==btninsert) { // ȸ������--------------------------------------------------------------------------------
			// ctel, cname �Է¶��� �����ϰ� ��Ʈ�� �� �ʱⰪ���� ����
			txtcid.setText("");
			txtcpoint.setText("1000");
			txtcamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtctel.getText().trim();
			String cname = txtcname.getText().trim();
			if(ctel.length()<8||cname.length()<2) {
				txtpool.setText("��ȭ��ȣ�� �̸��� �ʼ� �Է»����Դϴ�");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result==CustomerDao.SUCCESS) {
				txtpool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���Լ����� �帳�ϴ�");
			}
		}else if(e.getSource()==btnctelupdate) { // ��ȣ����-----------------------------------------------------------------------------
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				ctel = txtctel.getText().trim();
				if(ctel.length()<8) {
					txtpool.setText("������ ��ȭ��ȣ�� Ȯ�����ּ���");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�");
			}else {
				txtpool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
			}
		}else if(e.getSource()==btndelete) { // ȸ��Ż��--------------------------------------------------------------------------------
			// ctel �����ϰ� �ʱ�ȭ
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String ctel = txtctel.getText().trim();
			if(ctel.equals("")) {
				txtpool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�� ���ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtpool.setText("ȸ��Ż�� �Ϸ�");
				txtctel.setText("");
			}else {
				txtpool.setText("��ϵ� ��ȭ��ȣ�� �ƴմϴ�");
			}
		}else if(e.getSource()==btnexit) { // ������----------------------------------------------------------------------------------
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SuperMng("���۸��� ����");
	}
}
