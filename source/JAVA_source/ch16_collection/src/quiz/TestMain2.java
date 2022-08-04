package quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> map = new HashMap<String, Member>();
		String answer, name, tel, address;
		while(true) {
			System.out.println("회원가입 하시겠습니까?(Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")) {
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("번호 입력");
				tel = sc.next();
				if(map.get(tel) !=null) {
					System.out.println("중복된 번호입니다.");
					continue;
				}
				System.out.println("주소 입력");
				sc.nextLine();
				address = sc.nextLine();
				map.put(tel, new Member(name, tel, address));
			}
		}
		sc.close();
		if(map.isEmpty()) {
			System.out.println("가입된 회원 정보 없음");
		}else {
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				System.out.println(map.get(key));
			}
		}
	}
}
