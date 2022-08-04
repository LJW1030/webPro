package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		BookLib book1 = new BookLib("89��-01", "java", "ȫ�浿");
		BookLib book2 = new BookLib("89��-02", "DBMS", "����");
		System.out.println(book1);
		try {
			book1.checkOut("�����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// ������ ����
		book1.setCheckoutDate(new Date(122, 2, 11)); // 3��11�Ͽ� ������
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(book1);
	}
}
