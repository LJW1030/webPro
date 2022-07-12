package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Dao {
	
	private String driver= "oracle.jdbc.driver.OracleDriver";
	private String url= "jdbc:oracle:thin:@localhost:1521:xe";
	private static int SUCCESS=1;
	private static int FAIL=0;
	private static Dao INSTANCE = new Dao();
	public static Dao getinstance() {
		return INSTANCE;
	}
	
	public Dao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 고객등급 출력
	public Vector<String> getlevelname() {
		Vector<String> levelnames = new Vector<String>();
		levelnames.add("");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				levelnames.add(rs.getString("levelname"));
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
		return levelnames;
	}
	// 아이디 검색
	public Dto getid(int cid) {
		Dto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"(SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"FROM CUS_LEVEL L, CUSTOMER C" + 
				"WHERE L.LEVELNO = C.LEVELNO" + 
				"AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dto = new Dto(cid, ctel, cname, cpoint, camount, levelname, forlevelup);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
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
	// 번호4자리 검색
	public ArrayList<Dto> getphone(String ctel) {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
					ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new Dto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
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
	// 이름검색
	public ArrayList<Dto> getname(String cname) {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, \r\n" + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp\r\n" + 
				"    FROM CUSTOMER C, CUS_LEVEL L\r\n" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND CNAME=? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new Dto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
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
	// 포인트로 구매
	public int buypoint(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
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
	//물품구매
	public int buy(int cid, int camount) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT + (?*0.05),\r\n" + 
				"                      cAMOUNT = cAMOUNT + ?,\r\n" + 
				"                      LEVELNO = (SELECT L.LEVELNO\r\n" + 
				"                                    FROM CUSTOMER C, CUS_LEVEL L\r\n" + 
				"                                    WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)\r\n" + 
				"    WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
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
	// 등급별 출력
	public ArrayList<Dto> getgrade(String levelname) {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME=? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelname);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new Dto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
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
	//전체출력
	public ArrayList<Dto> output() {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, \r\n" + 
				"            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND L.LEVELNO!=5) forLevelUp\r\n" + 
				"    FROM CUSTOMER C, CUS_LEVEL L\r\n" + 
				"    WHERE C.LEVELNO = L.LEVELNO ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new Dto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
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
	// 회원가입
}
