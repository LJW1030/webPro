package string;

import java.util.Scanner;

public class Pracetice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] f = {new Friend("홍길이","010-9999-9999","03-21"),
					  new Friend("헤헤군","010-8888-8888","11-11"),
					  new Friend("칙칙이","010-7777-7777","07-08"),
					  new Friend("삼발이","010-6666-6666","05-31"),
					  new Friend("중추기","010-5555-5555","04-22")};
	while(true) {
		System.out.println("원하는 친구번호의 뒷자리 : (끝내기: P)");
		String num = sc.next();
		if(num.equalsIgnoreCase("p")) break;
		boolean searchOK = false;
		for(int i=0; i<f.length; i++) {
			String tel = f[i].getPhone();
			String post = tel.substring(tel.lastIndexOf('-')+1);
			if(num.equals(post)) {
				System.out.println(f[i]);
				searchOK = true;
			}
		}
		if(!searchOK) {
			System.out.println("조회되지 않는 번호입니다.");
		}
	}
	System.out.println("DONE");
	}
}
