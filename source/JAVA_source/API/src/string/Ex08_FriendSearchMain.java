package string;

import java.util.Scanner;

public class Ex08_FriendSearchMain {

	public static void main(String[] args) {

		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-25"),
						   new Friend("김길동", "010-8888-8888", "03-13"),
						   new Friend("박길동", "010-7777-7777", "02-18"),
						   new Friend("이길동", "010-6666-6666", "12-08"),
						   new Friend("이진우", "010-5555-5555", "10-30")};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("원하는 친구의 번호 뒷자리를 입력하세요(끝내기 : p)");
			String num = sc.next();
			if(num.equalsIgnoreCase("p")) break;
			boolean searchOK = false;
			for(int i=0; i<friends.length; i++) {
				String tel = friends[i].getPhone();
				String post = tel.substring(tel.lastIndexOf('-')+1);
				if(post.equals(num)) {
					System.out.println(friends[i]);
					searchOK = true;
				}
			}
			if(!searchOK) {
				System.out.println("조회되지않는 번호입니다.");
			}
	}
		System.out.println("DONE");
	}
}
