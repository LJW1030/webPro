package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("�μ�����?");
		String dname = sc.next();
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER('"+dname+"')";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("���\t"+"�̸�\t"+"��å\t"+"�޿�");
			if(rs.next()) {
				do {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
				} while(rs.next());
			}else {
				System.out.println("��ȿ���� ���� �μ���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {}
		}
	}
}
