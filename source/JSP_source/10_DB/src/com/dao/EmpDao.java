package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.EmpDto;

public class EmpDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static EmpDao instance;
	public static EmpDao getInstance() {
		if(instance==null) {
			instance = new EmpDao();
		}
		return instance;
	}
	private EmpDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//searchName을 매개변수로 받아 EmpDto를 return
	public ArrayList<EmpDto> selectSearchName(String searchName){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(?)||'%'";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate= rs.getDate("hiredate");
				int sal      = rs.getInt("sal");
				int comm     = rs.getInt("comm");
				int deptno   = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!= null) 
					rs.close();
				if(pstmt!= null) 
					pstmt.close();
				if(conn!= null) 
					conn.close();
			} catch (Exception e2) {}
		}
		return dtos;
	}
	// deptno를 매개변수로 받아 EmpDTO들 return
		public ArrayList<EmpDto> selectDeptno(int deptno){
			ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
			// 2단계 ~ 7단계
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM EMP WHERE DEPTNO=?";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
				pstmt = conn.prepareStatement(sql); // (3)
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery(); // (4) + (5)
				while(rs.next()) {
					int empno    = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job   = rs.getString("job");
					int mgr      = rs.getInt("mgr");
					Date hiredate= rs.getDate("hiredate");
					int sal      = rs.getInt("sal");
					int comm     = rs.getInt("comm");
					dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs    != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return dtos;
		}
}
