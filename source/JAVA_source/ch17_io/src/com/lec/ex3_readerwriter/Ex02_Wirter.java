package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Wirter {

	public static void main(String[] args) {
		Writer writer =null;
		try {
			writer = new FileWriter("txt_forder/outTest.txt", true); // true�� �߰�, �������� ������
			String msg = "\n\n�߰��� �ؽ�Ʈ �����Դϴ�.����";
			writer.write(msg);
			System.out.println("���� ��� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer != null)
					writer.close();
			} catch (Exception e2) {
			}
		}
	}
}
