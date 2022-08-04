package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int EXPEL=1;
	public static int NONEXPEL=0;
	public static int SUCCESS=1;
	public static int FAIL   =0;
	private static StudentDao INSTANCE;
	public static StudentDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0번 전공이름들 콤보박스에 추가
	public Vector<String> Mnamelist() {
		Vector<String> mname = new Vector<String>();
		mname.add("");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mname.add(rs.getString("mname"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
		return mname;
	}
	// 1번 학번검색
	public StudentDto sNogetStudent(int sno) {
	StudentDto dto = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
			"        FROM STUDENT S, MAJOR M" + 
			"        WHERE S.MNO = M.MNO" + 
			"        AND SNO=?";
	try {
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		rs = pstmt.executeQuery();
		if(rs.next()){
			String sname = rs.getString("sname");
			String mname = rs.getString("mname");
			int score = rs.getInt("score");
			dto = new StudentDto (sname, mname, score, sno);
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
// 2번 이름검색
	public ArrayList<StudentDto> sNamegetStudent(String sname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
				"        FROM STUDENT S, MAJOR M" + 
				"        WHERE S.MNO = M.MNO" + 
				"        AND SNAME=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int sno = rs.getInt("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(sname, mname, score, sno));
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
// 3번 전공검색
	public ArrayList<StudentDto> mNamegetStudent(String mname) {
		ArrayList<StudentDto> dtos2 = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE" + 
				"    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
				"                FROM STUDENT S, MAJOR M" + 
				"                WHERE S.MNO=M.MNO" + 
				"                AND MNAME=?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				dtos2.add(new StudentDto(rank, 0, mname, 0, sname, score));
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
		return dtos2;
	}
	// 4번 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE)\r\n" + 
				"VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')), ?, (SELECT MNO FROM MAJOR WHERE MNAME=?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
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
	//5번 학생수정
public int updateStudent(StudentDto dto) {
	int result = FAIL;
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "UPDATE STUDENT SET SNAME=?, MNO =(SELECT MNO FROM MAJOR WHERE MNAME=?), SCORE=? WHERE SNO = ?";
	try {
		conn = DriverManager.getConnection(url,"scott","tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getSname());
		pstmt.setString(2, dto.getMname());
		pstmt.setInt(3, dto.getScore());
		pstmt.setInt(4, dto.getSno());
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
	//6번 학생출력
public ArrayList<StudentDto> getStudent() {
	ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE" + 
			"    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
			"                FROM STUDENT S, MAJOR M" + 
			"                WHERE S.MNO=M.MNO AND SEXPEL=1" + 
			"                ORDER BY SCORE DESC)";
	try {
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
		StudentDto dto = new StudentDto();
		dto.setRank(rs.getInt("rank"));
		dto.setSname(rs.getString("sname"));
		dto.setMname(rs.getString("mname"));
		dto.setScore(rs.getInt("score"));
		dtos.add(dto);
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
// 7번 제적자 출력
public ArrayList<StudentDto> getExpel() {
	ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE" + 
			"    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
			"                FROM STUDENT S, MAJOR M" + 
			"                WHERE S.MNO=M.MNO AND SEXPEL=0" + 
			"                ORDER BY SCORE DESC)";
	try {
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
		StudentDto dto = new StudentDto();
		dto.setRank(rs.getInt("rank"));
		dto.setSname(rs.getString("sname"));
		dto.setMname(rs.getString("mname"));
		dto.setScore(rs.getInt("score"));
		dtos.add(dto);
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
// 8번 제적처리
	public int sNoExpel(int sno) {
	int result = FAIL;
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "UPDATE STUDENT SET SEXPEL = 0 WHERE SNO=?";
	try {
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		result=pstmt.executeUpdate();
		
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
