package string;

import java.util.Scanner;

//����. �ֹι�ȣ�� �Է¹޾� �������� �������� ��� ����. �ֹι�ȣ�� ��920225-2012121���������� �Է¹޴´�.
public class Ex04_juminNo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��Ͻÿ�");
		String no = sc.next();
		
		if(no.charAt(7) == '1' || no.charAt(7) == '3') {
			System.out.println("�����Դϴ�.");
		}else if(no.charAt(7) == '2' || no.charAt(7) == '4') {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("�ùٸ� �ֹι�ȣ�� �Է����ּ���.");
		}
	}

}
