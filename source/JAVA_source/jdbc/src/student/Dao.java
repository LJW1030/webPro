package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Dao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static Dao INSTANCE;
	public static Dao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new Dao();
		}
		return INSTANCE;
	}
	public Dao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 전공 콤보박스에 추가
	public Vector<String> getMnamelist() {
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "DBtest", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		return mnames;
	}
	
}
