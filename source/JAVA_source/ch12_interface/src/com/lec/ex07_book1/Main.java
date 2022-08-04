package com.lec.ex07_book1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Book[] books = {new Book("890��-101-1��","java","ȫ�浿"),
						new Book("111��-111-1��","dbms","�ű浿"),
						new Book("111��-111-1��","web","��浿"),
						new Book("111��-111-1��","jsp","���浿"),
						new Book("111��-111-1��","spring","�ڱ浿")};
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:���� | 2:�ݳ� | 3:ålist | 0:����)
		int idx; // �����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å�̸�,������,������
		do {
			System.out.println("1:���� | 2:�ݳ� | 3:ålist | 0:����");
			fn = scanner.nextInt();
			switch (fn) {
			case 1:
				//����: 1.å�̸� �Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
				//1.å�̸��Է�
				System.out.println("�����ϰ��� �ϴ� å �̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				//2.å��ȸ
				for(idx=0; idx<books.length; idx++) {
					if((bTitle).equals(books[idx].getBookTitle())  ) {
						break;
					}
				}//å ��ȸ for
				if (idx==books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else { // books[idx] ������ ����ó��
					//3.å���� Ȯ��
					if(books[idx].getState() == Book.STATE_BORROWED) { //����Ұ� ����
						System.out.println("���� �������� �����Դϴ�.");
					}else { // ���Ⱑ�� ����
						//4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
						System.out.println("�����ڴ� ?");
						borrower = scanner.next();
						System.out.println("�������� ?");
						checkOutDate = scanner.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
					break;
			case 2: // �ݳ� : 1.å�̸� 2.å��ȸ 3.�ݳ�
				// 1.å�̸�
				System.out.print("�ݳ��� å �̸���?");
				bTitle = scanner.next();
				// 2.å��ȸ
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				}else { // idx�� ã�� �� ��ġ
					// 3. �ݳ�
					books[idx].checkIn();
				}
				break;
			case 3:
			System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for(Book b : books) {
					b.printState();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("BYE");
//		while(true) {
//			System.out.println("1:���� | 2:�ݳ� | 3:ålist | 0:����");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
			scanner.close();
//			}
//		}
		
	}
}

