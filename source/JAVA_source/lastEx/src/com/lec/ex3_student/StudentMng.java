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
		btnsnoSerach = new JButton("학번검색");
		btnsnameSearch = new JButton("이름검색");
		btnmnameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentout = new JButton("학생출력");
		btnExpelout = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		txtpool = new JTextArea(10,50);
		scrollPane = new JScrollPane(txtpool);
		jpup.add(new JLabel("학번",(int) CENTER_ALIGNMENT));
		jpup.add(txtsno);
		jpup.add(btnsnoSerach);
		jpup.add(new JLabel("이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtsname);
		jpup.add(btnsnameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnmnameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
		if(e.getSource()==btnsnoSerach) { //학번검색
			txtsname.setText("");
			txtscore.setText("");
			comMname.setSelectedIndex(0);
			String sno = txtsno.getText().trim();
			if(sno.equals("")) {
				txtpool.setText("학번을 입력하시오");
				return;
			}
			StudentDto dto = dao.sNogetStudent(Integer.parseInt(sno));
			if(dto!=null) {
				txtsname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtscore.setText(String.valueOf(dto.getScore()));
				txtpool.setText(sno+"번 검색 완료");
			}else
				txtpool.setText(sno+"번은 없는 학번입니다");
		}
		else if(e.getSource()==btnsnameSearch) { // 이름검색
			txtsno.setText("");
			txtscore.setText("");
			comMname.setSelectedIndex(0);
			String sname = txtsname.getText().trim();
			if(sname.length()==0) {
				txtpool.setText("이름을 입력하시오");
				return;
			}
			ArrayList<StudentDto> dto1 = dao.sNamegetStudent(sname);
			if(dto1.size()==0) {
				txtpool.setText("해당 이름의 학생은 없습니다");
			}else if(dto1.size()==1) {
				txtsno.setText(String.valueOf(dto1.get(0).getSno()));
				comMname.setSelectedItem(dto1.get(0).getMname());
				txtscore.setText(String.valueOf(dto1.get(0).getScore()));
				txtpool.setText(sname+"학생의 정보출력 완료");
			}else {
				txtpool.setText("\t학번\t이름\t학과명\t점수\n");
				txtpool.append("\t-----------------------\n");
				for(StudentDto s : dto1) {
					txtpool.append("\t"+s.toString()+"\n");
				}
			}
		}
		else if(e.getSource()==btnmnameSearch) { // 전공검색
			txtsno.setText("");
			txtsname.setText("");
			txtscore.setText("");
			String mname = comMname.getSelectedItem().toString();
			ArrayList<StudentDto> dtos = dao.mNamegetStudent(mname);
			if(!dtos.isEmpty()) {
				txtpool.setText("\t등수\t이름\t학과명\t점수\n");
				txtpool.append("\t---------------------------------------------------------------\n");
				for(StudentDto s : dtos) {
					txtpool.append("\t"+s.toString()+"\n");
				}
			}
			else {
				txtpool.setText("해당학과 학생이 없습니다");
			}
		}
		else if(e.getSource()==btnInput) { // 학생입력
			txtsno.setText("");
			String sname = txtsname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String score = txtscore.getText().trim();
			if(sname.equals("")||mname.equals("")||score.equals("")) {
				txtpool.setText("이름,전공,점수 모두 입력하시오");
				return;
			}
			int score1;
			try {
				score1 = Integer.parseInt(score);
				if(score1<0 || score1>100) {
					txtpool.setText("0~100 사이의 점수 입력하시오");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("정보를 모두 입력하시오");
				return;
			}	
			StudentDto newS = new StudentDto(sname, mname, score1);
			int result = dao.insertStudent(newS);
			if(result == StudentDao.FAIL) {
				txtpool.setText(sname + " 학생 입력 성공");
				txtsno.setText("");
				txtsname.setText("");
				comMname.setSelectedIndex(0);
				txtscore.setText("");
			}
		}
		else if(e.getSource()==btnUpdate) { //학생수정
			String sno = txtsno.getText().trim();
			String sname = txtsname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			String score = txtscore.getText().trim();
			if(sname.equals("")||mname.equals("")||score.equals("")) {
				txtpool.setText("이름,전공,점수 모두 입력하시오");
				return;
			}
			int score1;
			try {
				score1 = Integer.parseInt(score);
				if(score1<0 || score1>100) {
					txtpool.setText("0~100 사이의 점수 입력하시오");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("정보를 모두 입력하시오");
				return;
			}	
			StudentDto newS = new StudentDto(sname, mname, score1, Integer.parseInt(sno));
			int result = dao.insertStudent(newS);
			if(result == StudentDao.FAIL) {
				txtpool.setText(sname + " 학생 정보 수정 성공");
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
				txtpool.setText("\t학번\t이름\t학과명\t점수\n");
				txtpool.append("\t─────────────────────────────────\n");
				for(StudentDto student : s) {
					txtpool.append("\t"+student.toString()+"\n");
				}//for
			}else {
				txtpool.setText("등록된 학생이 없습니다");
			}
		}
		else if(e.getSource()==btnExpelout) {
			txtsno.setText("");
			txtsname.setText("");
			comMname.setSelectedIndex(0);
			txtscore.setText("");
			ArrayList<StudentDto> s = dao.getExpel();
			if(s.size()!=0) {
				txtpool.setText("\t학번\t이름\t학과명\t점수\n");
				txtpool.append("\t─────────────────────────────────\n");
				for(StudentDto student : s) {
					txtpool.append("\t"+student.toString()+"\n");
				}//for
			}else {
				txtpool.setText("등록된 학생이 없습니다");
			}
		}
		else if(e.getSource()==btnExpel) {
			String sno = txtsno.getText().trim();
			if(sno.length()==0) {
				txtpool.setText("학번 입력하시오");
				return;
			}
			int result = dao.sNoExpel(Integer.parseInt(sno));
			if(result == StudentDao.SUCCESS) {
				txtpool.setText("제적처리완료");
			}else {
				txtpool.setText("유효한 학번 아닙니다");
			}
	}
		else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
}
	public static void main(String[] args) {
		new StudentMng("학사관리");
	}
}
