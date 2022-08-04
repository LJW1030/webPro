package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS=1;
	public static int FAIL   =0;
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0. 레벨 이름들 검색 : public Vector<String> getLevelNames()
	public Vector<String> getLevelNames() { 
		Vector<String> levelNames = new Vector<String>();
		levelNames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				levelNames.add(rs.getString("levelname"));
			}
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
		return levelNames;
	}
	// 1. ID검색 : public CustomerDto cIdGetCustomer(int cId)
	// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
	public CustomerDto cIdGetCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLevelUp" + 
				"        FROM CUSTOMER C, CUS_LEVEL L" + 
				"        WHERE  C.LEVELNO = L.LEVELNO AND CID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// int cid = rs.getInt("cid"); - 매개변수로 이미 받음
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forlevelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
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
	// 2. 폰4자리(FULL) 검색 : public ArrayList<CustomerDto> cTelGetCustomer(String ctel)
	// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
	public ArrayList<CustomerDto> cTelGetCustomer(String ctel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLevelUp" + 
				"        FROM CUSTOMER C, CUS_LEVEL L" + 
				"        WHERE  C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid"); 
					ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return dtos;
	}
	// 3. 고객이름검색 : ArrayList<CustomerDto> cNAmeGetCustomer(String cname)
	// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
	public ArrayList<CustomerDto> cNameGetCustomer(String cname) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLevelUp" + 
				"        FROM CUSTOMER C, CUS_LEVEL L" + 
				"        WHERE  C.LEVELNO = L.LEVELNO AND CNAME=?" + 
				"        ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid"); 
				String ctel = rs.getString("ctel");
				//String cname = rs.getString("cname"); -- 매개변수로 받음
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return dtos;
	}
	// 4. 포인트로만 구매(1번 id가 100원 구매) : int buyWithPoint(int cid, int camount)
	public int buyWithPoint(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
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
	// 5. 물품 구매 : int buy(int cid, int camount)
	// 물품구매 update에는 cpoint, camount, levelNo가 수정
	public int buy(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT + (?*0.05)," + 
				"                       CAMOUNT = CAMOUNT+?," + 
				"                       LEVELNO =(SELECT L.LEVELNO " + 
				"                       FROM CUSTOMER C, CUS_LEVEL L" + 
				"                       WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)" + 
				"                       WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
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
	// 6. 등급별 출력 : ArrayList<CustmoerDto> levelNameGetCustomer(String levelName)
	// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
	public ArrayList<CustomerDto> levelNameGetCustomer(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLevelUp" + 
				"        FROM CUSTOMER C, CUS_LEVEL L" + 
				"        WHERE  C.LEVELNO = L.LEVELNO AND LEVELNAME=?" + 
				"        ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid"); 
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				//levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return dtos;
	}
	// 7. 전체 출력 : ArrayList<CustomerDto> getCustomers()
	// CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
	public ArrayList<CustomerDto> getCustmoers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLevelUp" + 
				"        FROM CUSTOMER C, CUS_LEVEL L" + 
				"        WHERE  C.LEVELNO = L.LEVELNO" + 
				"        ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid"); 
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int forLevelUp = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
		return dtos;
	}
	// 8. 회원가입 : int insertCustomer(String ctel, String cname)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + 
				"        VALUES (CUS_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
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
	// 9. 번호 수정 : int updateCustomer(int cid, String ctel)
	public int updateCustomer(int cid, String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
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
	// 10. 회원탈퇴 : int deleteCustomer(String ctel)
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
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
}
