package com.lec.ex3_student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class StudentMng extends JFrame implements ActionListener {
	private StudentDao dao = StudentDao.getInstance();
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtsno, txtsname, txtscore;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JButton btnsnoSerach, btnsnameSearch, btnmnameSearch;
	private JButton btnInput, btnUpdate, btnStudentout, btnExpelout, btnExpel, btnExit;
	private JTextArea txtpool;
	private JScrollPane scrollPane;
	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		txtsno = new JTextField(10);
		txtsname = new JTextField(10);
		txtscore = new JTextField(10);
		mnames = dao.Mnamelist();
		comMname = new JComboBox<String>(mnames);
		btnsnoSerach = new JButton("�й��˻�");
		btnsnameSearch = new JButton("�̸��˻�");
		btnmnameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentout = new JButton("�л����");
		btnExpelout = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		txtpool = new JTextArea(10,50);
		scrollPane = new JScrollPane(txtpool);
		jpup.add(new JLabel("�й�",(int) CENTER_ALIGNMENT));
		jpup.add(txtsno);
		jpup.add(btnsnoSerach);
		jpup.add(new JLabel("�̸�",(int) CENTER_ALIGNMENT));
		jpup.add(txtsname);
		jpup.add(btnsnameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnmnameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtscore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentout);
		jpbtn.add(btnExpelout);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600,400));
		setLocation(500,500);
		setVisible(true);
		btnsnoSerach.addActionListener(this);
		btnsnameSearch.addActionListener(this);
		btnmnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentout.addActionListener(this);
		btnExpelout.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnsnoSerach) { //�й��˻�
			txtsname.setText("");
			txtscore.setText("");
			comMname.setSelectedIndex(0);
			String sno = txtsno.getText().trim();
			if(sno.equals("")) {
				txtpool.setText("�й��� �Է��Ͻÿ�");
				return;
			}
			StudentDto dto = dao.sNogetStudent(Integer.parseInt(sno));
			if(dto!=null) {
				txtsname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtscore.setText(String.valueOf(dto.getScore()));
				txtpool.setText(sno+"�� �˻� �Ϸ�");
			}else
				txtpool.setText(sno+"���� ���� �й��Դϴ�");
		}
		else if(e.getSource()==btnsnameSearch) { // �̸��˻�
			txtsno.setText("");
			txtscore.setText("");
			comMname.setSelectedIndex(0);
			String sname = txtsname.getText().trim();
			if(sname.length()==0) {
				txtpool.setText("�̸��� �Է��Ͻÿ�");
				return;
			}
			ArrayList<StudentDto> dto1 = dao.sNamegetStudent(sname);
			if(dto1.size()==0) {
				txtpool.setText("�ش� �̸��� �л��� �����ϴ�");
			}else if(dto1.size()==1) {
				txtsno.setText(String.valueOf(dto1.get(0).getSno()));
				comMname.setSelectedItem(dto1.get(0).getMname());
				txtscore.setText(String.valueOf(dto1.get(0).getScore()));
				txtpool.setText(sname+"�л��� ������� �Ϸ�");
			}else {
				txtpool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtpool.append("\t-----------------------\n");
				for(StudentDto s : dto1) {
					txtpool.append("\t"+s.toString()+"\n");
				}
			}
		}
		else if(e.getSource()==btnmnameSearch) { // �����˻�
			txtsno.setText("");
			txtsname.setText("");
			txtscore.setText("");
			String mname = comMname.getSelectedItem().toString();
			ArrayList<StudentDto> dtos = dao.mNamegetStudent(mname);
			if(!dtos.isEmpty()) {
				txtpool.setText("\t���\t�̸�\t�а���\t����\n");
				txtpool.append("\t---------------------------------------------------------------\n");
				for(StudentDto s : dtos) {
					txtpool.append("\t"+s.toString()+"\n");
				}
			}
			else {
				txtpool.setText("�ش��а� �л��� �����ϴ�");
			}
		}
		else if(e.getSource()==btnInput) { // �л��Է�
			txtsno.setText("");
			String sname = txtsname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String score = txtscore.getText().trim();
			if(sname.equals("")||mname.equals("")||score.equals("")) {
				txtpool.setText("�̸�,����,���� ��� �Է��Ͻÿ�");
				return;
			}
			int score1;
			try {
				score1 = Integer.parseInt(score);
				if(score1<0 || score1>100) {
					txtpool.setText("0~100 ������ ���� �Է��Ͻÿ�");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("������ ��� �Է��Ͻÿ�");
				return;
			}	
			StudentDto newS = new StudentDto(sname, mname, score1);
			int result = dao.insertStudent(newS);
			if(result == StudentDao.FAIL) {
				txtpool.setText(sname + " �л� �Է� ����");
				txtsno.setText("");
				txtsname.setText("");
				comMname.setSelectedIndex(0);
				txtscore.setText("");
			}
		}
		else if(e.getSource()==btnUpdate) { //�л�����
			String sno = txtsno.getText().trim();
			String sname = txtsname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String score = txtscore.getText().trim();
			if(sname.equals("")||mname.equals("")||score.equals("")) {
				txtpool.setText("�̸�,����,���� ��� �Է��Ͻÿ�");
				return;
			}
			int score1;
			try {
				score1 = Integer.parseInt(score);
				if(score1<0 || score1>100) {
					txtpool.setText("0~100 ������ ���� �Է��Ͻÿ�");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("������ ��� �Է��Ͻÿ�");
				return;
			}	
			StudentDto newS = new StudentDto(sname, mname, score1, Integer.parseInt(sno));
			int result = dao.insertStudent(newS);
			if(result == StudentDao.FAIL) {
				txtpool.setText(sname + " �л� ���� ���� ����");
				txtsno.setText("");
				txtsname.setText("");
				comMname.setSelectedIndex(0);
				txtscore.setText("");
			}
		}
		else if(e.getSource()==btnStudentout) {
			txtsno.setText("");
			txtsname.setText("");
			comMname.setSelectedIndex(0);
			txtscore.setText("");
			ArrayList<StudentDto> s = dao.getStudent();
			if(s.size()!=0) {
				txtpool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtpool.append("\t������������������������������������������������������������������\n");
				for(StudentDto student : s) {
					txtpool.append("\t"+student.toString()+"\n");
				}//for
			}else {
				txtpool.setText("��ϵ� �л��� �����ϴ�");
			}
		}
		else if(e.getSource()==btnExpelout) {
			txtsno.setText("");
			txtsname.setText("");
			comMname.setSelectedIndex(0);
			txtscore.setText("");
			ArrayList<StudentDto> s = dao.getExpel();
			if(s.size()!=0) {
				txtpool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtpool.append("\t������������������������������������������������������������������\n");
				for(StudentDto student : s) {
					txtpool.append("\t"+student.toString()+"\n");
				}//for
			}else {
				txtpool.setText("��ϵ� �л��� �����ϴ�");
			}
		}
		else if(e.getSource()==btnExpel) {
			String sno = txtsno.getText().trim();
			if(sno.length()==0) {
				txtpool.setText("�й� �Է��Ͻÿ�");
				return;
			}
			int result = dao.sNoExpel(Integer.parseInt(sno));
			if(result == StudentDao.SUCCESS) {
				txtpool.setText("����ó���Ϸ�");
			}else {
				txtpool.setText("��ȿ�� �й� �ƴմϴ�");
			}
	}
		else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
}
	public static void main(String[] args) {
		new StudentMng("�л����");
	}
}
