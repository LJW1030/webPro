package string;

import java.util.Scanner;

public class Pracetice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] f = {new Friend("ȫ����","010-9999-9999","03-21"),
					  new Friend("���챺","010-8888-8888","11-11"),
					  new Friend("ĢĢ��","010-7777-7777","07-08"),
					  new Friend("�����","010-6666-6666","05-31"),
					  new Friend("���߱�","010-5555-5555","04-22")};
	while(true) {
		System.out.println("���ϴ� ģ����ȣ�� ���ڸ� : (������: P)");
		String num = sc.next();
		if(num.equalsIgnoreCase("p")) break;
		boolean searchOK = false;
		for(int i=0; i<f.length; i++) {
			String tel = f[i].getPhone();
			String post = tel.substring(tel.lastIndexOf('-')+1);
			if(num.equals(post)) {
				System.out.println(f[i]);
				searchOK = true;
			}
		}
		if(!searchOK) {
			System.out.println("��ȸ���� �ʴ� ��ȣ�Դϴ�.");
		}
	}
	System.out.println("DONE");
	}
}
