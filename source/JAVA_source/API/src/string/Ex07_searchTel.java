package string;
// �迭�� �ִ� ��ȭ��ȣ ã�� ��ü ��ȭ��ȣ ���

import java.util.Scanner;

public class Ex07_searchTel {

	public static void main(String[] args) {
		
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-7777"};
		Scanner sc = new Scanner(System.in);
		String searchTel;
		boolean searchOK = false;
		System.out.println("���ϴ� ��ȣ�� ���ڸ��� �Է��Ͻÿ�.");
		searchTel = sc.next(); // ex)1234
		for(int i=0; i<tels.length; i++) {
			String post = tels[i].substring(tels[i].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("���ϴ� ��ȣ�� "+tels[i]+"�Դϴ�.");
				searchOK = true;
			}
		}
			if(! searchOK) { // saerchTel�� �迭 ��ȭ�� ��� ��ã�� idx�� ������ �� ���
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�");
	}
			sc.close();
	}
}
