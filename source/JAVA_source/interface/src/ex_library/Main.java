package ex_library;

import java.util.Scanner;

import ex_library2.BookLib;

public class Main {

	public static void main(String[] args) {
		Book[] books = { new Book("111-1111", "�λ�å", "������"),
				         new Book("222-2222", "��å", "�ڼ���"),
				         new Book("111-2222", "�ذ�å", "���츮"),
				         new Book("222-1111", "�ǰ���å", "���찡"),
				         new Book("333-3333", "��å", "���ϸ��� ����")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String borrower,bTitle,checkOutDate;
		do {
			System.out.println("1.����   |  2.�ݳ�   |  3.å��Ȳ  |  0.����");
			fn = sc.nextInt();
			switch(fn) {
			case 1:
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
						if(books[idx].getState() == Book.STATE_BORROWED) {
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
						books[idx].checkIn();
					}
					break;
				case 3:
					System.out.println("å ����Ʈ");
					for(Book book : books) {
						book.printState();
					}
					break;
				}
		}while(fn!=0);
	}
}


