package com.lec.ex1_string;

public class Ex2_StringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCxabc");
		String str3 = "          ja           va          ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcAABCXabc
		System.out.println("2. "+str2.substring(3)); // Xabc
		System.out.println("3. "+str1.substring(3,5)); //2¹øÂ°ºÎÅÍ 5¹øÂ°±îÁö
		System.out.println("4. "+str1.length()); // ±ÛÀÚ±æÀÌ7
		System.out.println("5. "+str1.toUpperCase()); // ´ë¹®ÀÚ·Î ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // ¼Ò¹®ÀÚ·Îabcxabc
		System.out.println("7. "+str1.charAt(3)); // 3¹øÂ° ¹®ÀÚ 'X'
		System.out.println("8. "+str1.indexOf('b')); // Ã¹¹øÂ° 'b'°¡ ³ª¿À´Â ÀÎµ¦½º 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° 'b'À§Ä¡
		System.out.println("10. "+str1.indexOf("abc"));
		System.out.println("11. "+str1.indexOf("abc",3)); // Ã¹¹øÂ° "abc"³ª¿À´Â À§Ä¡
		System.out.println("12. "+str1.indexOf("z")); // ¾øÀ¸¸é -1
		System.out.println("13. "+str1.lastIndexOf('b')); // ¸¶Áö¸· 'b' À§Ä¡5
		System.out.println("14. "+str1.lastIndexOf('b',3)); //3¹øÂ°ºÎÅÍ ¸Ç ¸¶Áö¸· b 1
		System.out.println("15. "+str1.equals(str2)); // str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // ´ë¼Ò¹³¤¤ÀÚ ±¸ºĞ¾øÀÌ ºñ±³ true
		System.out.println("17. "+str3.trim()); // ¾ÕµÚ°ø¹é Á¦°Å ja        va
		System.out.println("18. "+str1.replace('a', '9')); // 'a'¸¦ '9'·Î 9bcX9bc
		System.out.println("19. "+str1.replace("abc", "µåµå"));// "abc"¸¦ "µåµå"·Î ¼öÁ¤ µåµåXµåµå
		System.out.println("strÀÇ space¸¦ ¾ø¾Ö±â : "+str3.replace(" ", ""));
		System.out.println("20. "+str1.replaceAll("abc", "Z")); // "abc"¸¦ "Z"·Î
		String str = "¾È³çHello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));
		System.out.println(str.replaceAll("[°¡-ÆR]", ""));
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
	}
}
