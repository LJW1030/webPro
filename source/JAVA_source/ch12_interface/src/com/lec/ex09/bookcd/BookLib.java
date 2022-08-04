package com.lec.ex09.bookcd;

public class BookLib extends BookInfo implements ILendable {
	
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println(getBookTitle()+" 도서는 대출중인 상태입니다.");
			return;
		}
		System.out.println();
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub

	}

}
