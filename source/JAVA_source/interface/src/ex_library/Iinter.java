package ex_library;

public interface Iinter {
	public byte STATE_BORROWED = 1; // 대출 중
	public byte STATE_NORMAL = 0;   // 대출되지 않은 상태
	public void checkOut(String borrower, String checkOutDate); // 대출
	public void checkIn();    // 반납
	public void printState(); // 대출상태
}
