package string;

import java.util.Scanner;

public class Ex08_FriendSearchMain {

	public static void main(String[] args) {

		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "05-25"),
						   new Friend("��浿", "010-8888-8888", "03-13"),
						   new Friend("�ڱ浿", "010-7777-7777", "02-18"),
						   new Friend("�̱浿", "010-6666-6666", "12-08"),
						   new Friend("������", "010-5555-5555", "10-30")};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("���ϴ� ģ���� ��ȣ ���ڸ��� �Է��ϼ���(������ : p)");
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
				System.out.println("��ȸ�����ʴ� ��ȣ�Դϴ�.");
			}
	}
		System.out.println("DONE");
	}
}
