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
			System.out.println(getBookTitle() + " ���� ���� �Ϸ� �߽��ϴ�.");
			return;
		}
		System.out.println(getBookTitle() + " ������ �̹� �������Դϴ�.");
		System.out.println("������ : " + borrower + "������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + " ������ �������� ���°� �ƴմϴ�.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ� �Ǿ����ϴ�.");
	}

	@Override
	public void toStirng() {
		if (state == STATE_BORRWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")���� ������ \t������");
		} else if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")���� ������ \t���� ����");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + ")���� ������ ���� \t���� ����");
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
