package wrapper;

import java.util.Scanner;

// »ç¿ëÀÚ·ÎºÎÅÍ Á¤¼ö¹®ÀÚ¿­("100")À» ÀÔ·Â¹Ş¾Æ Á¤¼ö·Î ¼öÁ¤ÇØ¼­ Ãâ·ÂÇÏ´Â ÇÁ·Î±×·¥
public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
		String numStr = sc.nextLine();
		numStr = numStr.trim(); // ÁÂ¿ì space°¡  Á¦°Å
		numStr = numStr.replaceAll("[a-zA-z¤¡-ÆR !@#$]", ""); // ¹®ÀÚ Á¦°Å
		int num = Integer.parseInt(numStr);
		System.out.println("º¯ÇüµÈ Á¡¼ö´Â "+num);
	}
}
