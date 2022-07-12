package ex_library2;

public interface IBookInter {

	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkOut(String borrower,String checkOutDate);
	public void CheckIn();
	public void printState();
}

