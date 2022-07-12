package string;
// 배열에 있는 전화번호 찾아 전체 전화번호 출력

import java.util.Scanner;

public class Ex07_searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-7777"};
		Scanner sc = new Scanner(System.in);
		String searchTel;
		boolean searchOK = false;
		System.out.println("원하는 번호의 뒷자리를 입력하시오.");
		searchTel = sc.next(); // ex)1234
		for(int i=0; i<tels.length; i++) {
			String post = tels[i].substring(tels[i].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("원하는 번호는 "+tels[i]+"입니다.");
				searchOK = true;
			}
		}
			if(! searchOK) { // saerchTel이 배열 전화에 없어서 못찾고 idx가 끝까지 간 경우
				System.out.println("검색하신 전화번호는 없습니다");
	}
			sc.close();
	}
}
