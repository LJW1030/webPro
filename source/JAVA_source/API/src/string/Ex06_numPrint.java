package string;

import java.util.Scanner;

// ��ȭ��ȣ �Է¹޾� ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
public class Ex06_numPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�. (������ : p)");
			String num = sc.next();
			if(num.equalsIgnoreCase("p")) break;
			System.out.println("¦����° ���� : ");
			for(int i=0; i<num.length(); i++) {
				if(i%2 ==0) {
				System.out.print(num.charAt(i));
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("��ȣ�� �Ųٷ�: ");
			for(int i=num.length()-1; i>=0; i--) {
				System.out.print(num.charAt(i));
			}
			System.out.println();
			int str1 = num.indexOf('-');
			int str2 = num.lastIndexOf('-');
			String pre = num.substring(0, str1);
			String mid = num.substring(str1+1,str2);
			String last = num.substring(str2+1);
			System.out.println("��ȭ��ȣ ���ڸ�: "+pre);
			System.out.println("��ȭ��ȣ �߰��ڸ�: "+mid);
			System.out.println("��ȭ��ȣ ���ڸ�: "+last);
			
		}
		sc.close();
	}

}
