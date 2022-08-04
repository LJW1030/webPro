package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

// 1. ��Ʈ����ü(�Է¿�, ��¿�) 2. �а� ���� 3. ���� �ݴ´�.(��Ʈ����ü.close)
public class Ex05_filecopyStep3 {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("d:\\webPro\\google.jpg");
			is = new FileInputStream(file); // 1.
			os = new FileOutputStream("d:/webPro/google_copyed.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];
			while (true) { // 2.
				int readByteCount = is.read(bs); // ���� ũ�⸸ŭ�� byte �б�
				if (readByteCount == -1)
					break; // ������ ������ ����
				os.write(bs, 0, readByteCount); // bs�� 0�� index���� readByteCount��ŭ ����
				cnt++;
			}
			System.out.println(cnt + "�� while�� �����Ͽ� ����� ���� ����");
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
