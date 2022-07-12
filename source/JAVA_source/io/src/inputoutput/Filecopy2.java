package inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Filecopy2 {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		File file = new File("f:/webPro/pic.png");
		try {
		is = new FileInputStream(file);
		os = new FileOutputStream("f:/webPro/pic2.png");
		byte[] bs = new byte[(int)file.length()];
		int cnt = 0;
		while(true) {
			int i = is.read(bs);
			if(i == -1) break;
			os.write(bs);
			cnt++;
		}
		System.out.println(cnt+"번 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			if(os != null) 
				os.close();
			if(is != null)
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		}
	}
}
