package com.lec.ex3_readerwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_BufferReader {

	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader= new FileReader("txt_forder/inTest.txt"); // 1. ���ν�Ʈ�� ����
			br = new BufferedReader(reader); // ������Ʈ�� ����
			int cnt = 0;
			while(true) {
				String linedata = br.readLine(); // 2. 1�پ� �б�
				if(linedata == null) { // ������ ���ΰ�� break
					break;
				}
					System.out.println(++cnt+linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br != null)
					br.close();
				if(reader != null)
					reader.close();
				} catch (Exception e2) {
			}
		}
	}
}
