package scanner;

import java.util.Scanner;

public class Ex01_nextLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); // '\n' �տ� �ִ� ���ڸ� return
		System.out.println("�Է��Ͻ� ���̴� "+age);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next(); // whitespace�ձ��� ���� return
		System.out.println("�Է��Ͻ� �̸��� "+name);
		
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		sc.nextLine(); // ���ۿ� �����ִ� '\n'�� ����� ����
		String address = sc.nextLine(); // '\n' �տ� �ִ� ���� return�ϰ�
		System.out.println("�Է��Ͻ� �ּҴ� "+address);
		sc.close();
	}

}
