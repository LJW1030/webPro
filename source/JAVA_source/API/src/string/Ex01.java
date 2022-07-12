package string;

public class Ex01 {

	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java"); // 무조건 객체 생성
		if(str1 == str2) {
			System.out.println("두 변수는 같은 주소값");
		}else {
			System.out.println("두 변수는 다른 주소값");
		}
		if(str1.equals(str2) ) {
			System.out.println("같은 문자열");
		}
		System.out.println(str1 == str3 ? "두 변수는 같은 주소값" : "두 변수는 다른 주소값");
		System.out.println(str1.equals(str3)? "같은 문자열" : "다른 문자열");
	}
}
