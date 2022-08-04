package quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Prac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> map = new HashMap<String, Member>();
		String ans, name, tel, address;
		while (true) {
			System.out.println("회원가입?Y/N");
			ans = sc.next();
			if (ans.equalsIgnoreCase("n")) {
				break;
			} else if (ans.equalsIgnoreCase("y")) {
				System.out.println("이름");
				name = sc.next();
				System.out.println("번호");
				tel = sc.next();
				if (map.get(tel) != null) {
					System.out.println("중복된 번호입니다.");
					continue;
				}
				System.out.println("주소");
				sc.nextLine();
				address = sc.nextLine();
				map.put(tel, new Member(name, tel, address));
			}
		}
		if (map.isEmpty()) {
			System.out.println("가입된 정보가 없습니다");
		} else {
			Iterator<String> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(map.get(key));
			}

		}
	}

}
