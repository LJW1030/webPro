package string;

public class Ex02 {

	public static void main(String[] args) {
		String str = "010-9999-9999  wkdrngla789@naver.com (02)565-8888 반갑습니다. Hello 961030-1011111,abc@naver.com";
		System.out.println(str);
		System.out.println("replace =>" + str.replace("0", "홍")); // 0만 홍으로 바뀜
		/* 정규표현식
		  1. 간략 문법
		  \d (숫자와 매치, [0~9]와 동일) \D(숫자가 안니 것)
		  \s (영문자나 숫자, [a-zA-Z0-9]와 동일) \W(영문자나 숫자가 아닌 문자)
		  . (문자 하나)
		  + (1번이상 반복)
		  * (0번이상 반복)
		  ? (0~1번 반복)
		  {2,4} (2~4회 반복)
		  2. 정규표현식 연습장 : http://regexpal.com  http://regexr.com
		  	ex. 전화번호: .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		  				이메일 : 
		  3. 특정 정규표현식의 문자열 변경 : replaceAll("정규표현식", "대체문자열")
		 */
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}" , "-- 전화번호 지움 --"));
		//전화번호 지움
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "-- 이메일 지움 --"));
		//이메일 지움
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//알파벳 대신 *로 대체
		System.out.println(str.replaceAll("[가-하ㄱ-ㅎ]", "*"));
		//한글 대신 *로 대체
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
		//주민번호 뒷자리를 *로 대체
		
	}

}
