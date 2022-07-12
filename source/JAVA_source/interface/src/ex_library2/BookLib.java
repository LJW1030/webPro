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
			System.out.println(getBookTitle()+"�� �̹� �������� ����");
			return;
		}
		System.out.println(getBookTitle()+" ���� ���� �Ϸ�");
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
			System.out.println(getBookTitle()+"�ݳ� �Ϸ�");
			return;
		}
		System.out.println("�ݳ� ������ ������ �ƴ�");
	}

	@Override
	public void printState() {
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle()+"������ \t���� �Ұ�");
		}else if(state == STATE_NORMAL) {
			System.out.println(getBookTitle()+"������ \t���� ����");
		}else {
			System.out.println(getBookTitle()+"�� �������� �ֹ��ƴ�");
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
