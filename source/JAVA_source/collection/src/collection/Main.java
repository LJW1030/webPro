package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> mem = new ArrayList<Member>();
		String ans, name, tel, address;
		while(true) {
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?(Y?N)");
			ans = sc.next();
			if(ans.equalsIgnoreCase("n")) {
				break;
			}else if(ans.equalsIgnoreCase("y")) {
				System.out.println("�̸� �Է�");
				name = sc.next();
				System.out.println("��ȭ��ȣ �Է�");
				tel = sc.next();
				sc.nextLine();
				System.out.println("�ּ� �Է�");
				address = sc.nextLine();
				mem.add(new Member(name, tel, address));
			}
		}
		if(mem.isEmpty()) {
			System.out.println("ȸ�������� �����ϴ�.");
		}else {
			System.out.println("ȸ�� ����");
			for(Member m : mem) {
				System.out.println(m);
			}
		}
	}
}