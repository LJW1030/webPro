package com.lec.ex2_datastream;

import java.io.*;
// 1.스트림객체 생성 == 파일을 연다 2.데이터쓴다 3.스트림객체 닫는다 == 파일을 닫는다
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txt_forder/dataFile.dat", true); // 기본스트림
			dos = new DataOutputStream(fos); // 보조스트림은 기본 스트림을 통해서망 가능
			// 이름-학년-점수-write
			dos.writeUTF("홍길이"); // String값 저장
			dos.writeInt(2);      // int값 저장
			dos.writeDouble(95.5);// double값 저장
			
			dos.writeUTF("김길이"); // String값 저장
			dos.writeInt(3);      // int값 저장
			dos.writeDouble(98.5);// double값 저장
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos != null) dos.close();
				if(fos != null) fos.close();
			} catch (IOException e2) {
			}
		}
	}
}
