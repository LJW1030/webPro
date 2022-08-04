package com.lec.ex08_book2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BookLib[] bs = { new BookLib("111-1111","재밌다","이진우"),
						 new BookLib("222-2222","재밌어","진우리"),
						 new BookLib("333-3333","재밌군","진우"),
						 new BookLib("444-4444","재밌네","찐진우"),
						 new BookLib("555-5555","재밌어요","진우다")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate; 
		do {
			System.out.println("1.대출  |  2.반납  |  3.책현황  |  0.종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1: 
				System.out.println("원하는 도서를 입력하시오.");
				bTitle = sc.next();
				for(idx=0; idx<bs.length; idx++) {
					if(bs[idx].getBookTitle().equals(bTitle)){
					break;
				}
				}
					if(idx==bs.length) {
						System.out.println("현재 없는 도서입니다.");
					}else {
						if(bs[idx].getState()==BookLib.STATE_NORMAL) {
							System.out.println("대출인 이름");
							borrower = sc.next();
							System.out.println("대출 날짜");
							checkOutDate = sc.next();
							bs[idx].checkOut(borrower, checkOutDate);
						}
						else {
							System.out.println("이미 대출 중인 도서입니다.");
						}break;
					}
			case 2:
				System.out.println("반납할 도서 이름을 입력하시오.");
				bTitle = sc.next();
				for(idx=0; idx<bs.length; idx++) {
					if(bs[idx].getBookTitle().equals(bTitle)){
					break;
					}
				}
				if(idx==bs.length) {
				System.out.println("해당 도서는 도서관의 책이 아닙니다.");
				}else {
				bs[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("현재 책현황 입니다.");
				for(BookLib b : bs) {
					b.toStirng();
				}	
				break;
			}
		}while(fn!=0);
		System.out.println("안녕히 가십시오.");
		sc.close();
	}
}
