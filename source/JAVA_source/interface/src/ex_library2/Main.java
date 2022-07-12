package ex_library2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BookLib[] books = {new BookLib("111-1111", "�ȳ�", "����"),
						   new BookLib("222-2222", "�׷�", "����"),
						   new BookLib("333-3333", "����", "���"),
						   new BookLib("444-4444", "����", "����")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		do {
			System.out.println("1.���� | 2.�ݳ� | 3.å ��Ȳ | 0.����");
			fn = sc.nextInt();
		switch(fn) {
		case 1: //����
			System.out.println("�����ϰ���� å�̸�");
			bTitle = sc.next();
			for(idx=0; idx<books.length; idx++) {
				if(bTitle.equals (books[idx].getBookTitle())) {
				break;
				}
			}
				if(idx==books.length) {
					System.out.println("�ش� ������ �����ϰ����� �ʴ�.");
				}else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("�������� ����");
					}else {
						System.out.println("��������?");
						borrower = sc.next();
						System.out.println("��������?");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
				}
			}
			break;
			case 2:
				System.out.print("�ݳ��� å�̸���?");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴ�");
				}else {
					books[idx].CheckIn();
				}
				break;
			case 3:
				System.out.println("å ����Ʈ");
				for(BookLib book : books) {
					book.printState();
				}
				break;
			}
			
		}while(fn!=0);
		System.out.println("�ȳ��� ���ʽÿ�.");
		
	}

}
