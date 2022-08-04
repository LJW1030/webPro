package com.lec.ex07_book1;
// Book 작업명세
public interface ILendable {
	public byte STATE_BORROWED = 1; // 대충 중
	public byte STATE_NORMAL = 0; // 대출되지 않은 상태(대출가능)
	public void checkOut(String borrower, String checkOutDate); // 대출 시 대출인과 대출일 이용
	public void checkIn(); // 반납 (연체료, 연체기간, 연체했는지, 연체패널티
	public void printState(); // 도서정보와 대출 상태 출력
}
