package wrapper;

import java.util.Scanner;

// ����ڷκ��� �������ڿ�("100")�� �Է¹޾� ������ �����ؼ� ����ϴ� ���α׷�
public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		String numStr = sc.nextLine();
		numStr = numStr.trim(); // �¿� space��  ����
		numStr = numStr.replaceAll("[a-zA-z��-�R !@#$]", ""); // ���� ����
		int num = Integer.parseInt(numStr);
		System.out.println("������ ������ "+num);
	}
}
