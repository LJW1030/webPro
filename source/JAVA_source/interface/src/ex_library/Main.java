package ex_library;

import java.util.Scanner;

import ex_library2.BookLib;

public class Main {

	public static void main(String[] args) {
		Book[] books = { new Book("111-1111", "인생책", "이진우"),
				         new Book("222-2222", "논리책", "박소현"),
				         new Book("111-2222", "해결책", "진우리"),
				         new Book("222-1111", "건곤일책", "진우가"),
				         new Book("333-3333", "손책", "무하마드 진우")};
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String borrower,bTitle,checkOutDate;
		do {
			System.out.println("1.대출   |  2.반납   |  3.책현황  |  0.종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1:
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
						if(books[idx].getState() == Book.STATE_BORROWED) {
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
						books[idx].checkIn();
					}
					break;
				case 3:
					System.out.println("책 리스트");
					for(Book book : books) {
						book.printState();
					}
					break;
				}
		}while(fn!=0);
	}
}


