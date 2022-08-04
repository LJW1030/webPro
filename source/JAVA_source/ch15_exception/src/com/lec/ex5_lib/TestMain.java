package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		BookLib book1 = new BookLib("89ㅁ-01", "java", "홍길동");
		BookLib book2 = new BookLib("89ㅁ-02", "DBMS", "김길길");
		System.out.println(book1);
		try {
			book1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 대출일 조작
		book1.setCheckoutDate(new Date(122, 2, 11)); // 3월11일에 대출함
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(book1);
	}
}
