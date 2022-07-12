package string;

import java.util.Scanner;

//예제. 주민번호를 입력받아 여자인지 남자인지 출력 예제. 주민번호는 “920225-2012121”형식으로 입력받는다.
public class Ex04_juminNo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하시오");
		String no = sc.next();
		
		if(no.charAt(7) == '1' || no.charAt(7) == '3') {
			System.out.println("남성입니다.");
		}else if(no.charAt(7) == '2' || no.charAt(7) == '4') {
			System.out.println("여성입니다.");
		}else {
			System.out.println("올바른 주민번호를 입력해주세요.");
		}
	}

}
