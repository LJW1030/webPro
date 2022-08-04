package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. 스트링객체(입력용, 출력용) 2. 읽고 쓴다 3. 파일 닫는다.(스트링객체.close)
public class Ex05_filecopyStep2 {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\webPro\\google.jpg"); // 1.
			os = new FileOutputStream("d:/webPro/google_copyed.jpg");
			int cnt = 0;
			byte[] bs = new byte[1024];
			while (true) { // 2.
				int readByteCount = is.read(bs); // 1024 byte 읽기
				if (readByteCount == -1)
					break; // 파일의 끝인지 여부
				os.write(bs, 0, readByteCount); // bs를 0번 index부터 readByteCount만큼 쓴다
				cnt++;
			}
			System.out.println(cnt + "번 while문 실행하여 힘들게 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
			}
		}
	}
}
