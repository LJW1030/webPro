package inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Filecopy1 {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		int cnt =0;
		try {
			is = new FileInputStream("f:/webPro/pic.png");
			os = new FileOutputStream("f:/webPro/pic1.png");
			while(true) {
				int i =is.read();
				if(i == -1) break;
				os.write(i);
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
					is.close();
			} catch (Exception e2) {
			}
		}
	}
}
