package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> mem = new ArrayList<Member>();
		String ans, name, tel, address;
		while(true) {
			System.out.println("회원가입 하시겠습니까?(Y?N)");
			ans = sc.next();
			if(ans.equalsIgnoreCase("n")) {
				break;
			}else if(ans.equalsIgnoreCase("y")) {
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("전화번호 입력");
				tel = sc.next();
				sc.nextLine();
				System.out.println("주소 입력");
				address = sc.nextLine();
				mem.add(new Member(name, tel, address));
			}
		}
		if(mem.isEmpty()) {
			System.out.println("회원정보가 없습니다.");
		}else {
			System.out.println("회원 정보");
			for(Member m : mem) {
				System.out.println(m);
			}
		}
	}
}