package scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("�̸� ?");
		String name = scMain.nextLine();
		System.out.println("�Է��Ͻ� �̸��� "+name);
		nickName();
		System.out.println("���� ?");
		int age = scMain.nextInt();
		System.out.println("�Է��Ͻ� ���̴� "+age);
		scMain.close();
	}
	private static void nickName() { // ����ڷκ��� ������ �޾� ����ϴ� �޼ҵ�
		Scanner scNickName = new Scanner(System.in);
		System.out.println("������ ?");
		System.out.println("�Է��Ͻ� ������ "+scNickName.nextLine());
//		scNickName.close();
	}
}
