package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1:�Է� 2:��������ȸ 3:��ü��ȸ �׿�:����
public class PersonMng {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null; // 1, 2�� ���
		Statement stmt = null; // 3�� ���
		ResultSet rs = null;
		String fn, sql;
		try {
			Class.forName(driver); // (1) ����̹� �ε�
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // (1)����̹� �ε�
		do {
			System.out.println("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�: ����");
			fn = sc.next(); // 1,2,3,a...
			switch(fn) {
			case "1" : //�̸�, ������, ��, ����, �� �Է¹޾� insert
				// 2~7 �ܰ�
				sql = "INSERT INTO PERSON" + 
						"    VALUES (PER_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					pstmt = conn.prepareStatement(sql); // 3
					System.out.println("�Է��� �̸���?");
					pstmt.setString(1, sc.next());
					System.out.println("������(���, ����)��?");
					pstmt.setString(2, sc.next());
					System.out.println("��������");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("��������");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("��������");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate(); // 4 + 5
					System.out.println(result>0 ? "�Է¼���" : "�Է½���");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(pstmt!=null)
							pstmt.close();
						if(conn!=null)
							conn.close();
					} catch (Exception e2) {}
				}
				break;
			case "2" :  // �������� �Է¹޾� �ش� ������ ��ȸ ���
				// 2~7 �ܰ�
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO AND JNAME= ?" + 
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					pstmt = conn.prepareStatement(sql); // 3
					System.out.println("������(���,����)��?");
					pstmt.setString(1, sc.next()); 
					rs = pstmt.executeQuery(); // 4+5
					if(rs.next()) { // ������ ���
						System.out.println("rank\t�̸�\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rank"); 
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null)
							rs.close();
						if(pstmt!=null)
							pstmt.close();
						if(conn!=null)
							conn.close();
					} catch (Exception e2) {}
				}
				break;
			case "3" : // ��ü ���
				// 2~7 �ܰ�
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO" +
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					stmt = conn.createStatement(); // 3
					rs = stmt.executeQuery(sql); // 4+5
					if(rs.next()) { // ������ ���
						System.out.println("rank\t�̸�\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rank"); 
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"\t"+pname+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null)
							rs.close();
						if(pstmt!=null)
							pstmt.close();
						if(conn!=null)
							conn.close();
					} catch (Exception e2) {}
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		sc.close();
		System.out.println("BYE");
	}
}
