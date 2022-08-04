package com.lec.ex08_book2;

public class BookLib extends BookInfo implements ILendable {

	private String borrower;
	private String checkOutDate;
	private byte state;

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_NORMAL) {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORRWED;
			System.out.println(getBookTitle() + " 도서 대출 완료 했습니다.");
			return;
		}
		System.out.println(getBookTitle() + " 도서는 이미 대출중입니다.");
		System.out.println("대출인 : " + borrower + "대출일 : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + " 도서는 대출중인 상태가 아닙니다.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " 도서가 반납 완료 되었습니다.");
	}

	@Override
	public void toStirng() {
		if (state == STATE_BORRWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")지음 도서는 \t대출중");
		} else if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")지음 도서는 \t대출 가능");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")지음 도서에 대한 \t정보 없음");
		}
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}
