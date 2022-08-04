package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arr = new ArrayList<Member>();
		String answer, name, tel, address;
		do {
			System.out.println("회원가입 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y"))
				System.out.println("이름은?");
				name = sc.next();
				System.out.println("전화번호는?");
				tel = sc.next();
				System.out.println("주소는?");
				sc.nextLine();
				address = sc.nextLine();
				arr.add(new Member(name, tel, address));
		}while(true);
		sc.close();
		if(arr.isEmpty()) {
			System.out.println("가입한 회원이 없다.");
		}else { 
			System.out.println("가입한 회원 list");
			for(Member m : arr) {
				System.out.println(m);
			}
		}
	}
	
}
