package ex1_tryCatch;
import java.util.InputMismatchException;
// ����: ArithmeticException, InputMismatchException
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1;
		do {
			try{
				System.out.print("��Ģ������ ù��° ���� ?");
				i = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("����1 �޽��� : "+e.getMessage());
				System.out.println("�ݵ�� ������ �Է��ϼ���");
				sc.nextLine();
			}
		}while(true);	
		System.out.print("��Ģ������ �ι�° ���� ?");
		try {
			j = sc.nextInt();
			System.out.println("i = "+i+", j = "+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j));
		}catch(InputMismatchException e) {
			System.out.println("����2 �޽��� : "+e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��� �� j=1");
		}catch(ArithmeticException e) {
			System.out.println("����3 �޽��� : "+e.getMessage());
		}catch(Exception e) {
			System.out.println("��� ���ܴ� �� ��������"+e.getMessage());
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
