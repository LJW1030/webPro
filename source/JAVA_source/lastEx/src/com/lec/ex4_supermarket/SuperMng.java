package com.lec.ex4_supermarket;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SuperMng extends JFrame implements ActionListener{
	// DAO
	private CustomerDao dao = CustomerDao.getInstance();
	// ȭ�鱸��
	private Container container;
	private JPanel    jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOuput, btnAllOutput, btnInsert,
					btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	public SuperMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������Ʈ ��ü ����
		container = getContentPane(); // �����̳ʴ� �⺻�� BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));  // �г��� �⺻�� FlowLayout
		jpbtn = new JPanel();
		txtCid     = new JTextField(20);
		txtCtel    = new JTextField(20);
		txtCname   = new JTextField(20);
		txtCpoint     = new JTextField(20);
		txtCamount    = new JTextField(20);
		levelNames    = dao.getLevelNames();
		comLevelName  = new JComboBox<String>(levelNames);
		btnCidSearch    = new JButton("���̵�˻�");
		btnCtelSearch   = new JButton("��4�ڸ�(FULL)�˻�");
		btnCnameSearch  = new JButton("���̸��˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ�����");
		btnBuy          = new JButton("��ǰ����");
		btnLevelNameOuput = new JButton("��޺����");
		btnAllOutput    = new JButton("��ü���");
		btnInsert       = new JButton("ȸ������");
		btnCtelUpdate   = new JButton("��ȣ����");
		btnDelete       = new JButton("ȸ��Ż��");
		btnExit         = new JButton("������");
		txtPool  = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		// �����̳ʿ� ������Ʈ ��ġ
		jpup.add(new JLabel("��  ��  ��", (int)CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("����ȭ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("���̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("��  ��  Ʈ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("���űݾ�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5�� 3���� �� �� �߰�
		jpup.add(new JLabel("�����", (int)CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOuput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(800,400));
		setLocation(200, 100);
		txtPool.setText("\t�ڡڡ� �� �˻� �� �����ϼ���");
		
		// �̺�Ʈ �߰�
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOuput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCidSearch) { // ���̵� �˻�
			// cid �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID�� �Է��Ͻ��� �˻��ϼ���");
				return;
			}//try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if(customer!=null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // ��ǰ���ž� ���� ����
				comLevelName.setSelectedItem(customer.getLevelName());
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������\n");
				txtPool.append(customer.toString());
			}else {
				txtPool.setText("�˻����� ���� ID�Դϴ�");
			}
		}else if(e.getSource()==btnCtelSearch) { // ��4�ڸ� �˻�
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.length()<4) {
				txtPool.setText("��� ��4�ڸ� �̻��� �Է��Ͽ��� �˻��˴ϴ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			}else {
				txtPool.setText("�ش� ��ȭ��ȣ�� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		}else if(e.getSource()==btnCnameSearch) { // �̸� �˻�
			// cname �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if(cname.length()<2) {
				txtPool.setText("��� �̸��� 2���� �̻��� �Է��Ͽ��� �˻��˴ϴ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			}else {
				txtPool.setText("�ش� �̸��� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		}else if(e.getSource()==btnBuyWithPoint) { // ����Ʈ����
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				if(cpoint < camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ ���Ű� �Ұ��մϴ�");
					return;
				}
			}catch (Exception e1) {
				txtPool.setText("��ȿ�� ��ID�� point�� ���űݾ��� �Է��Ͻ��� �����ϼ���");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ ���ż���");
				txtCpoint.setText(String.valueOf(cpoint-camount)); // ������ ����Ʈ�� ����
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ������ �ּ���");
			}
		}else if(e.getSource()==btnBuy) { // ��ǰ����
			int cid, cpoint, camount;
			try {
				cid     = Integer.parseInt(txtCid.getText().trim());
				cpoint  = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("��ȿ�� ��ID�� �˻���, ���űݾ��� �Է��Ͻð� �����ϼ���");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ ���� �Ϸ�");
				txtCpoint.setText(String.valueOf(cpoint + (int)(camount*0.05)));
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. �� �˻��� �����ϼ���");
			}			
		}else if(e.getSource()==btnLevelNameOuput) { // ��޺� ���
			// levelName �Է� �޺��ڽ� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			// comLevelName.setSelectedItem("");
			String levelName = comLevelName.getSelectedItem().toString();
			if(levelName.length()==0) {
				txtPool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ���");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("�� " + customers.size() + "��");
			}else {
				txtPool.setText("�ش� ������ ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		}else if(e.getSource()==btnAllOutput) {//��ü���
			// ��� �Է� ���۳�Ʈ�� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			ArrayList<CustomerDto> customers = dao.getCustomers();
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("�� " + customers.size() + "��");
			}else {
				txtPool.setText("��ϵ� ���� �˻����� �ʽ��ϴ�.");
			}	
		}else if(e.getSource()==btnInsert) {//ȸ������
			// ctel, cname �Է¶��� �����ϰ� ��Ʈ�� �� �ʱⰪ���� ����
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if(ctel.length()<8|| cname.length()<2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� Ȯ���� �ּ���(��ȭ��ȣ�� 8�ڸ� �̻�, �̸��� 2�����̻�)");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���Լ����� �帳�ϴ�");
			}					
		}else if(e.getSource()==btnCtelUpdate) {//��ȣ����
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("������ ��ȭ��ȣ�� Ȯ���� �ּ���");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�");
			}else {
				txtPool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
			}
		}else if(e.getSource()==btnDelete) { // ȸ��Ż��
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż���� �ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("ȸ��Ż�� �Ϸ�");
				txtCtel.setText("");
			}else {
				txtPool.setText("��ϵ� ��ȭ��ȣ�� �ƴϿ��� ȸ��Ż�� ���� �Ұ��մϴ�");
			}
		}else if(e.getSource()==btnExit) {// ������
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SuperMng("���۸��� ����");
	}
}













