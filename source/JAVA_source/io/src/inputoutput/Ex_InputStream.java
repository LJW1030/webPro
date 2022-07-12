package inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex_InputStream {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/input.txt");
			while(true) {
				int i = is.read();
				if(i==-1) break;
				System.out.print((char)i);
			}
			System.out.println("\n³¡");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is !=null)
					is.close();
			} catch (Exception e2) {
			}
		}
	}
}
