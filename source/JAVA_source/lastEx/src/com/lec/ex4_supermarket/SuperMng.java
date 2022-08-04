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
	//화면구현
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
		// 컴포넌트 객체 생성
		// 컨테이너에 컴포넌트 배치
		// 이벤트 추가
		container = getContentPane(); // 컨테이너는 기본 borderlayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6,3)); // 패널은 기본 flowlayout
		jpbtn = new JPanel();
		txtcid = new JTextField(20);
		txtctel = new JTextField(20);
		txtcname = new JTextField(20);
		txtcpoint = new JTextField(20);
		txtcamount = new JTextField(20);
		levelNames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);
		btncidsearch = new JButton("아이디 검색");
		btnctelsearch = new JButton("폰4자리(FULL) 검색");
		btncnamesearch = new JButton("고객 이름 검색");
		btnbuywithpoint = new JButton("포인트로만 구매");
		btnbuy = new JButton("물품 구매");
		btnlevelnameoutput = new JButton("등급별 출력");
		btnalloutput = new JButton("전체 출력");
		btninsert = new JButton("회원 가입");
		btnctelupdate = new JButton("번호수정");
		btndelete = new JButton("회원 탈퇴");
		btnexit = new JButton("나가기");
		txtpool = new JTextArea(6,70);
		scrollpane = new JScrollPane(txtpool);
		// 컨테이너에 배치
		jpup.add(new JLabel("아이디",(int) CENTER_ALIGNMENT));
		jpup.add(txtcid);
		jpup.add(btncidsearch);
		jpup.add(new JLabel("고객전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtctel);
		jpup.add(btnctelsearch);
		jpup.add(new JLabel("고객이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtcname);
		jpup.add(btncnamesearch);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtcpoint);
		jpup.add(btnbuywithpoint);
		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtcamount);
		jpup.add(new JLabel()); // 5행 3열 빈 라벨
		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
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
		txtpool.setText("\t★★★고객검색 후 구매하세요★★★");
		//이벤트 추가
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
		if(e.getSource()==btncidsearch) { // 아이디 검색 ----------------------------------------------------------------
			int cid;
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("유효한 고객 ID를 입력하신후 검색하세요");
				return;
			} // try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if(customer!=null) {
				//txtcid.setText(String.valueOf(customer.getCid()));
				txtctel.setText(customer.getCtel());
				txtcname.setText(customer.getCname());
				txtcpoint.setText(String.valueOf(customer.getCpoint()));
				txtcamount.setText(""); // 물품구매액 넣을 예정
				comLevelName.setSelectedItem(customer.getLevelName());
				txtpool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한 추가구매액\n");
				txtpool.append("------------------------------------------------------------\n");
				txtpool.append(customer.toString());
			}else {
				txtpool.setText("검색되지 않은 ID입니다");
			}
		}else if(e.getSource()==btnctelsearch) { // 폰4자리 검색-----------------------------------------------------------------
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String ctel = txtctel.getText().trim();
			if (ctel.length()<4) {
				txtpool.setText("4자리 이상의 번호를 입력하시오");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);
			if(customers.size()!=0) {
				txtpool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한 추가구매액\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtcid.setText(String.valueOf(c.getCid()));
					txtcname.setText(c.getCname());
					txtctel.setText(c.getCtel());
					txtcpoint.setText(String.valueOf(c.getCpoint()));
					txtcamount.setText(""); // 물품구매할 금액이 넣어질 예정인 textField
					comLevelName.setSelectedItem(c.getLevelName());
					txtpool.append(c.toString()+"\n");
				}
			}else {
				txtpool.setText("해당 번호의 고객은 없습니다");
			}
		}else if(e.getSource()==btncnamesearch) { // 이름 검색---------------------------------------------------------------------
			// cname 입력란 외에는 기본으로 비워놓고 로직 수행
			txtcid.setText("");
			txtctel.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String cname = txtcname.getText().trim();
			if (cname.length()<2) {
				txtpool.setText("두글자 이상의 이름을 입력하시오");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);
			if(customers.size()!=0) {
				txtpool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한 추가구매액\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtcid.setText(String.valueOf(c.getCid()));
					txtcname.setText(c.getCname());
					txtctel.setText(c.getCtel());
					txtcpoint.setText(String.valueOf(c.getCpoint()));
					txtcamount.setText(""); // 물품구매할 금액이 넣어질 예정인 textField
					comLevelName.setSelectedItem(c.getLevelName());
					txtpool.append(c.toString()+"\n");
				}
			}else {
				txtpool.setText("해당 이름의 고객은 없습니다");
			}
		}else if(e.getSource()==btnbuywithpoint) { // 포인트 구매---------------------------------------------------------------------
			int cid, cpoint, camount;
			try {
				 cid = Integer.parseInt(txtcid.getText().trim());
				 cpoint = Integer.parseInt(txtcpoint.getText().trim());
				 camount = Integer.parseInt(txtcamount.getText().trim());
				 if(cpoint < camount) {
					 txtpool.setText("포인트가 부족하여 포인트로 구매가 불가합니다");
					 return;
				 } 
			} catch (Exception e2) {
				txtpool.setText("유효한 고객ID와 point와 구매금액을 입력하신 후 구매하세요");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("포인트 구매성공");
				txtcpoint.setText(String.valueOf(cpoint-camount)); // 차감된 포인트로 수정
				txtcamount.setText("");
			}else {
				txtpool.setText("고객 아이디가 유효하지 않습니다. 고객 검색 후 구매바랍니다");
			}
		}else if(e.getSource()==btnbuy) { // 물품구매--------------------------------------------------------------------------------
			int cid, camount, cpoint;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("유효한 고객ID와 구매금액을 입력하시고 구매하세요");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("물품 구매 완료");
				txtcpoint.setText(String.valueOf(cpoint+(int)(camount*0.05)));
				txtcamount.setText("");
			}else {
				txtpool.setText("고객 아이디가 유효하지 않습니다, 고객 검색후 구매하세요");
			}
		}else if(e.getSource()==btnlevelnameoutput) { // 등급별 출력-------------------------------------------------------------------
			// levelName 입력 콤보박스 외에는 기본으로 비워놓고 로직 수행
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			// comLevelName.setSelectedIndex(0);
			String levelName = comLevelName.getSelectedItem().toString();
			if (levelName.length()==0) {
				txtpool.setText("원하는 등급을 선택하시고 검색하시오");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) {
				txtpool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한 추가구매액\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtpool.append(c.toString()+"\n");
				}
				txtpool.append("총"+customers.size()+"명");
			}else {
				txtpool.setText("해당 레벨의 고객은 없습니다");
			}
		}else if(e.getSource()==btnalloutput) { // 전체출력----------------------------------------------------------------------------
			// 모든 입력 컴포넌트를 비워놓고 로직 수행
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");;
			ArrayList<CustomerDto> customers = dao.getCustmoers();
			if(customers.size()!=0) {
				txtpool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한 추가구매액\n");
				txtpool.append("------------------------------------------------------------\n");
				for(CustomerDto c : customers) {
					txtpool.append(c.toString()+"\n");
				}
				txtpool.append("총"+customers.size()+"명");
			}else {
				txtpool.setText("등록된 고객이 없습니다");
			}
		}else if(e.getSource()==btninsert) { // 회원가입--------------------------------------------------------------------------------
			// ctel, cname 입력란을 제외하고 빈스트링 및 초기값으로 정리
			txtcid.setText("");
			txtcpoint.setText("1000");
			txtcamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtctel.getText().trim();
			String cname = txtcname.getText().trim();
			if(ctel.length()<8||cname.length()<2) {
				txtpool.setText("전화번호와 이름은 필수 입력사항입니다");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result==CustomerDao.SUCCESS) {
				txtpool.setText("회원가입 감사합니다. 포인트 1000점을 가입선물로 드립니다");
			}
		}else if(e.getSource()==btnctelupdate) { // 번호수정-----------------------------------------------------------------------------
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				ctel = txtctel.getText().trim();
				if(ctel.length()<8) {
					txtpool.setText("변경할 전화번호를 확인해주세요");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("유효한 고객 ID로 검색후 수정하세요");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtpool.setText("전화번호가 수정되었습니다");
			}else {
				txtpool.setText("유효한 고객 ID로 검색후 수정하세요");
			}
		}else if(e.getSource()==btndelete) { // 회원탈퇴--------------------------------------------------------------------------------
			// ctel 제외하고 초기화
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);
			String ctel = txtctel.getText().trim();
			if(ctel.equals("")) {
				txtpool.setText("전화번호를 입력 후 회원탈퇴 해주세요");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtpool.setText("회원탈퇴 완료");
				txtctel.setText("");
			}else {
				txtpool.setText("등록된 전화번호가 아닙니다");
			}
		}else if(e.getSource()==btnexit) { // 나가기----------------------------------------------------------------------------------
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SuperMng("슈퍼마켓 관리");
	}
}
