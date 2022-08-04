package com.lec.ex4_printWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {

	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
//			os = new FileOutputStream("txt_forder/outTest.txt",true); // 기본스트림
//			printWriter = new PrintWriter(os); // 보조스트림
//			writer = new FileWriter("txt_forder.outTest.txt", true); // 기본스트림
//			printWriter = new PrintWriter(writer);
			printWriter = new PrintWriter("txt_forder/outTest.txt"); // 파일 apped(true로 추가) 불가
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			
			System.out.print("print는 자동개행이 안돼서 개행추가\n");
			printWriter.print("print는 자동개행이 안돼서 개행추가\n");
		
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "홍길이", 90, 91, 90.5);
			printWriter.printf("%s \t %3d \t %3d \t %5.1f\n", "홍길이", 90, 91, 90.5);
			
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "신길이", 100, 95, 97.5);
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "신길이", 100, 95, 97.5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(printWriter != null)
				printWriter.close();
		}
	}
}
