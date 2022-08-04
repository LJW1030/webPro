package com.lec.ex09.bookcd;

public interface ILendable {

	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 1;
	public void checkOut(String borrower,String checkOutDate);
	public void checkIn();
	public void printState();
}
