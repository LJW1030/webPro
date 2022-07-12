package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> map = new HashMap<String, Member>();
		String ans,name,tel,address;
		while(true) {
			System.out.println("ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");
			ans = sc.next();
			if(ans.equalsIgnoreCase("n")) {
				break;
			}else if(ans.equalsIgnoreCase("y")) {
				System.out.println("�̸�");
				name = sc.next();
				System.out.println("��ȭ��ȣ");
				tel = sc.next();
				if(map.get(tel) != null) {
					System.out.println("�ߺ��� ��ȣ�Դϴ�. ������ �ٽ� �Է¹ٶ��ϴ�");
					continue;
				}
				System.out.println("�ּ�");
				sc.nextLine();
				address = sc.nextLine();
				map.put(tel, new Member(name,tel,address));
			}
		}
		if(map.isEmpty()) {
			System.out.println("ȸ������ ����");
		}else {
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				System.out.println(map.get(key));
			}
		}
	}
}
