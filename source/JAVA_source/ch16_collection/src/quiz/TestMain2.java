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
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?(Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")) {
				System.out.println("�̸� �Է�");
				name = sc.next();
				System.out.println("��ȣ �Է�");
				tel = sc.next();
				if(map.get(tel) !=null) {
					System.out.println("�ߺ��� ��ȣ�Դϴ�.");
					continue;
				}
				System.out.println("�ּ� �Է�");
				sc.nextLine();
				address = sc.nextLine();
				map.put(tel, new Member(name, tel, address));
			}
		}
		sc.close();
		if(map.isEmpty()) {
			System.out.println("���Ե� ȸ�� ���� ����");
		}else {
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				System.out.println(map.get(key));
			}
		}
	}
}
