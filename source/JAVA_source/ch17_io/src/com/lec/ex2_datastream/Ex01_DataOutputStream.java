package com.lec.ex2_datastream;

import java.io.*;
// 1.��Ʈ����ü ���� == ������ ���� 2.�����;��� 3.��Ʈ����ü �ݴ´� == ������ �ݴ´�
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txt_forder/dataFile.dat", true); // �⺻��Ʈ��
			dos = new DataOutputStream(fos); // ������Ʈ���� �⺻ ��Ʈ���� ���ؼ��� ����
			// �̸�-�г�-����-write
			dos.writeUTF("ȫ����"); // String�� ����
			dos.writeInt(2);      // int�� ����
			dos.writeDouble(95.5);// double�� ����
			
			dos.writeUTF("�����"); // String�� ����
			dos.writeInt(3);      // int�� ����
			dos.writeDouble(98.5);// double�� ����
			System.out.println("���� ���� �Ϸ�");
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
