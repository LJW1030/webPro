package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1:입력 2:직업별조회 3:전체조회 그외:종료
public class PersonMng {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null; // 1, 2번 기능
		Statement stmt = null; // 3번 기능
		ResultSet rs = null;
		String fn, sql;
		try {
			Class.forName(driver); // (1) 드라이버 로드
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // (1)드라이버 로드
		do {
			System.out.println("1:입력 || 2:직업별조회 || 3:전체조회 || 그외: 종료");
			fn = sc.next(); // 1,2,3,a...
			switch(fn) {
			case "1" : //이름, 직업명, 국, 영수, 수 입력받아 insert
				// 2~7 단계
				sql = "INSERT INTO PERSON" + 
						"    VALUES (PER_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					pstmt = conn.prepareStatement(sql); // 3
					System.out.println("입력할 이름은?");
					pstmt.setString(1, sc.next());
					System.out.println("직업명(배우, 가수)은?");
					pstmt.setString(2, sc.next());
					System.out.println("국어점수");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("영어점수");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("수학점수");
					pstmt.setInt(5, sc.nextInt());
					int result = pstmt.executeUpdate(); // 4 + 5
					System.out.println(result>0 ? "입력성공" : "입력실패");
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
			case "2" :  // 직업명을 입력받아 해당 직업별 조회 출력
				// 2~7 단계
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO AND JNAME= ?" + 
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					pstmt = conn.prepareStatement(sql); // 3
					System.out.println("직업명(배우,가수)은?");
					pstmt.setString(1, sc.next()); 
					rs = pstmt.executeQuery(); // 4+5
					if(rs.next()) { // 직업별 출력
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
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
						System.out.println("해당 직업의 사람이 입력되지 않았습니다.");
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
			case "3" : // 전체 출력
				// 2~7 단계
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO" +
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
					stmt = conn.createStatement(); // 3
					rs = stmt.executeQuery(sql); // 4+5
					if(rs.next()) { // 직업별 출력
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
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
						System.out.println("해당 직업의 사람이 입력되지 않았습니다.");
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
