package com.lec.ex08_book2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BookLib[] bs = { new BookLib("111-1111","��մ�","������"),
						 new BookLib("222-2222","��վ�","���츮"),
						 new BookLib("333-3333","��ձ�","����"),
						 new BookLib("444-4444","��ճ�","������"),
						 new BookLib("555-5555","��վ��","�����")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate; 
		do {
			System.out.println("1.����  |  2.�ݳ�  |  3.å��Ȳ  |  0.����");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				System.out.println("���ϴ� ������ �Է��Ͻÿ�.");
				bTitle = sc.next();
				for(idx=0; idx<bs.length; idx++) {
					if(bs[idx].getBookTitle().equals(bTitle)){
					break;
				}
				}
					if(idx==bs.length) {
						System.out.println("���� ���� �����Դϴ�.");
					}else {
						if(bs[idx].getState()==BookLib.STATE_NORMAL) {
							System.out.println("������ �̸�");
							borrower = sc.next();
							System.out.println("���� ��¥");
							checkOutDate = sc.next();
							bs[idx].checkOut(borrower, checkOutDate);
						}
						else {
							System.out.println("�̹� ���� ���� �����Դϴ�.");
						}break;
					}
			case 2:
				System.out.println("�ݳ��� ���� �̸��� �Է��Ͻÿ�.");
				bTitle = sc.next();
				for(idx=0; idx<bs.length; idx++) {
					if(bs[idx].getBookTitle().equals(bTitle)){
					break;
					}
				}
				if(idx==bs.length) {
				System.out.println("�ش� ������ �������� å�� �ƴմϴ�.");
				}else {
				bs[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("���� å��Ȳ �Դϴ�.");
				for(BookLib b : bs) {
					b.toStirng();
				}	
				break;
			}
		}while(fn!=0);
		System.out.println("�ȳ��� ���ʽÿ�.");
		sc.close();
	}
}
