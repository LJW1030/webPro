package ex_library;

public class Book implements Iinter {

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(bookTitle+" �� �̹� �������� ���� �Դϴ�.");
			return;
		}
			System.out.println(bookTitle+" ���� ���� �Ϸ�Ǿ����ϴ�.");
			System.out.println("������ : "+borrower+"\t������ : "+checkOutDate);
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
	}
	

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+" �� �̹� �ݳ��� �����Դϴ�.");
			return;
		}
			this.borrower = null;
			this.checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+" ������ �ݳ� �Ϸ� �Ǿ����ϴ�.");
	}
	@Override
	public void printState() {
		if(state == STATE_BORROWED) {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")����"+"\t���� ��");
		}else if(state == STATE_NORMAL) {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")����"+"\t���� ����");
		}else {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")����"+"\t���� �̻�");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "����)";
//		msg = msg + ( (state==STATE_NORMAL)? "���Ⱑ��" : (state==STATE_BORROWED)? "������":"�̻���" );
//		System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
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
