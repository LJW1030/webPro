package com.lec.ex08_book2;

public interface ILendable {

	public byte STATE_BORRWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void toStirng();
}
