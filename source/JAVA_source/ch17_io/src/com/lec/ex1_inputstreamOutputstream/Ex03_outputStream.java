package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

// 1. ���Ͽ���(��¿� ��Ʈ�� ��ü����) 2. write�Ѵ� 3. ������ �ݴ´�(��Ʈ����ü.close)
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
			System.out.println("���� ��� ����");
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
