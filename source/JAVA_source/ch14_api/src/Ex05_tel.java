import java.util.Scanner;

public class Ex05_tel {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String tel;
		while(true) {
			System.out.println("��ȣ�� �Է��Ͻÿ�.(X������ ����)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("¦�����ڿ� : ");
			for(int i=0; i<tel.length(); i++) {
				if(i%2==0) {
					System.out.print(tel.charAt(i));
				}else {
					System.out.print(' ');
				}
			}
			System.out.println();
			System.out.println("���� �Ųٷ�");
			for(int i=tel.length()-1; i>=0; i--) {
				System.out.print(tel.charAt(i));
			}
		}
	}
}
