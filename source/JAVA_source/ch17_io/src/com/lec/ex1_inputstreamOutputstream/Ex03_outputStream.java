package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

// 1. 파일연다(출력용 스트림 객체생성) 2. write한다 3. 파일을 닫는다(스트림객체.close)
public class Ex03_outputStream {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txt_forder/outTest.txt",true); //1.
			byte[] bs = {'H','e','l','l','o'};
//			for(int i=0; i<bs.length; i++) { // 2.
//				os.write(bs[i]);
//			}
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
