package exceptionExs;

import java.util.Date;

public class Ex02_FriendMain {

	public static void main(String[] args) {
		Friend f = new Friend("ȫ�浿", "010-1234-5678");
		f.setEnterDate(new Date(122, 2, 11));
		System.out.println(f);
		Friend f1 = new Friend("�赿");
		System.out.println(f1);
	}
}
