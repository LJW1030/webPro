package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dto.FriendDto;

public class FriendDao {

	private static final int SUCCESS = 1;
	private static final int FAIL = 0;
	
	private static FriendDao instance = new FriendDao();
	public static FriendDao getInstance() {
		return instance;
	}
	private FriendDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("커넥션풀 에러 : "+e.getMessage());
		}
		return conn;
	}
	public ArrayList<FriendDto> getFriend(){
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String fname = rs.getString("fname");
				String tel = rs.getString("tel");
				dto.add(new FriendDto(no, fname, tel));
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
		return dto;
	}
	public int addFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND VALUES (F_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFname());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "추가 성공" : "추가 실패");
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
		return result;
	}
	public ArrayList<FriendDto> searchFriend(String sfname, String stel){
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE FNAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sfname);
			pstmt.setString(2, stel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String fname = rs.getString("fname");
				String tel = rs.getString("tel");
				dto.add(new FriendDto(no, fname, tel));
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
		return dto;
	}
}
