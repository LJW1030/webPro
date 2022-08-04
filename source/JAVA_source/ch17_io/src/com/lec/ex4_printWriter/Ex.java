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
//			os = new FileOutputStream("txt_forder/outTest.txt",true); // �⺻��Ʈ��
//			printWriter = new PrintWriter(os); // ������Ʈ��
//			writer = new FileWriter("txt_forder.outTest.txt", true); // �⺻��Ʈ��
//			printWriter = new PrintWriter(writer);
			printWriter = new PrintWriter("txt_forder/outTest.txt"); // ���� apped(true�� �߰�) �Ұ�
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			
			System.out.print("print�� �ڵ������� �ȵż� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵż� �����߰�\n");
		
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "ȫ����", 90, 91, 90.5);
			printWriter.printf("%s \t %3d \t %3d \t %5.1f\n", "ȫ����", 90, 91, 90.5);
			
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "�ű���", 100, 95, 97.5);
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n", "�ű���", 100, 95, 97.5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(printWriter != null)
				printWriter.close();
		}
	}
}
