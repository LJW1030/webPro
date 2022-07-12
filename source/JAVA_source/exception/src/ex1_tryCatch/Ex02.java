package ex1_tryCatch;
//����ó�� �߰�
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��Ģ������ ù��° ���� ?");
		int i = sc.nextInt();
		System.out.print("��Ģ������ �ι�° ���� ?");
		int j = sc.nextInt();
		System.out.println("i = "+i+", j = "+j);
		System.out.println("i * j = "+(i*j));
		try {
			System.out.println("i / j = "+(i/j)); // ���� �߻� ���� �κ�
		}catch(Exception e) {
			// ���ܰ� �߻��� ��� ��ȸ������ ������ ����
			System.out.println("���ܸ޽��� : "+e.getMessage()); // ���ܸ޽����� ���
			//e.printStackTrace(); // ���ܻ����� �ڼ��� ���
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
