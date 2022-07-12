package ex_library2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BookLib[] books = {new BookLib("111-1111", "안녕", "진우"),
						   new BookLib("222-2222", "그래", "진진"),
						   new BookLib("333-3333", "나도", "우우"),
						   new BookLib("444-4444", "껴줘", "지누")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;
		do {
			System.out.println("1.대출 | 2.반납 | 3.책 현황 | 0.종료");
			fn = sc.nextInt();
		switch(fn) {
		case 1: //대출
			System.out.println("대출하고싶은 책이름");
			bTitle = sc.next();
			for(idx=0; idx<books.length; idx++) {
				if(bTitle.equals (books[idx].getBookTitle())) {
				break;
				}
			}
				if(idx==books.length) {
					System.out.println("해당 도서는 보유하고있지 않다.");
				}else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("대출중인 도서");
					}else {
						System.out.println("대출인은?");
						borrower = sc.next();
						System.out.println("대출일은?");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
				}
			}
			break;
			case 2:
				System.out.print("반납할 책이름은?");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아님");
				}else {
					books[idx].CheckIn();
				}
				break;
			case 3:
				System.out.println("책 리스트");
				for(BookLib book : books) {
					book.printState();
				}
				break;
			}
			
		}while(fn!=0);
		System.out.println("안녕히 가십시오.");
		
	}

}
