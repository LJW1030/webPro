package inputoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/output.txt", true);
			byte[] bs = {'H','e','l','l','o'};
			os.write(bs);
			System.out.println("출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null)
					os.close();
			} catch (Exception e2) {
			}
		}
		
	}
}
