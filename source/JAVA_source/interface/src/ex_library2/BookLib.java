package ex_library2;

public class BookLib extends BookInfo implements IBookInter {

	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle()+"은 이미 대출중인 도서");
			return;
		}
		System.out.println(getBookTitle()+" 도서 대출 완료");
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
	}

	@Override
	public void CheckIn() {
		if(state == STATE_BORROWED) {
			this.borrower = null;
			this.checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(getBookTitle()+"반납 완료");
			return;
		}
		System.out.println("반납 가능한 도서가 아님");
	}

	@Override
	public void printState() {
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle()+"도서는 \t대출 불가");
		}else if(state == STATE_NORMAL) {
			System.out.println(getBookTitle()+"도서는 \t대출 가능");
		}else {
			System.out.println(getBookTitle()+"은 정상적인 주문아님");
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
