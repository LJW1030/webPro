package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arr = new ArrayList<Member>();
		String answer, name, tel, address;
		do {
			System.out.println("ȸ������ �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y"))
				System.out.println("�̸���?");
				name = sc.next();
				System.out.println("��ȭ��ȣ��?");
				tel = sc.next();
				System.out.println("�ּҴ�?");
				sc.nextLine();
				address = sc.nextLine();
				arr.add(new Member(name, tel, address));
		}while(true);
		sc.close();
		if(arr.isEmpty()) {
			System.out.println("������ ȸ���� ����.");
		}else { 
			System.out.println("������ ȸ�� list");
			for(Member m : arr) {
				System.out.println(m);
			}
		}
	}
	
}
