package com.lec.ex1_string;

public class Ex2_StringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCxabc");
		String str3 = "          ja           va          ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcAABCXabc
		System.out.println("2. "+str2.substring(3)); // Xabc
		System.out.println("3. "+str1.substring(3,5)); //2번째부터 5번째까지
		System.out.println("4. "+str1.length()); // 글자길이7
		System.out.println("5. "+str1.toUpperCase()); // 대문자로 ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // 소문자로abcxabc
		System.out.println("7. "+str1.charAt(3)); // 3번째 문자 'X'
		System.out.println("8. "+str1.indexOf('b')); // 첫번째 'b'가 나오는 인덱스 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3번째부터 검색해서 첫번째 'b'위치
		System.out.println("10. "+str1.indexOf("abc"));
		System.out.println("11. "+str1.indexOf("abc",3)); // 첫번째 "abc"나오는 위치
		System.out.println("12. "+str1.indexOf("z")); // 없으면 -1
		System.out.println("13. "+str1.lastIndexOf('b')); // 마지막 'b' 위치5
		System.out.println("14. "+str1.lastIndexOf('b',3)); //3번째부터 맨 마지막 b 1
		System.out.println("15. "+str1.equals(str2)); // str1과 str2가 같은 문자열인지 false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // 대소뭄ㄴ자 구분없이 비교 true
		System.out.println("17. "+str3.trim()); // 앞뒤공백 제거 ja        va
		System.out.println("18. "+str1.replace('a', '9')); // 'a'를 '9'로 9bcX9bc
		System.out.println("19. "+str1.replace("abc", "드드"));// "abc"를 "드드"로 수정 드드X드드
		System.out.println("str의 space를 없애기 : "+str3.replace(" ", ""));
		System.out.println("20. "+str1.replaceAll("abc", "Z")); // "abc"를 "Z"로
		String str = "안녕Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));
		System.out.println(str.replaceAll("[가-힣]", ""));
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
	}
}
