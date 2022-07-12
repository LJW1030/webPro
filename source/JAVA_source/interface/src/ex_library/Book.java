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
			System.out.println(bookTitle+" 은 이미 대출중인 도서 입니다.");
			return;
		}
			System.out.println(bookTitle+" 도서 대출 완료되었습니다.");
			System.out.println("대출인 : "+borrower+"\t대출일 : "+checkOutDate);
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
	}
	

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+" 은 이미 반납된 도서입니다.");
			return;
		}
			this.borrower = null;
			this.checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+" 도서가 반납 완료 되었습니다.");
	}
	@Override
	public void printState() {
		if(state == STATE_BORROWED) {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")지음"+"\t대출 중");
		}else if(state == STATE_NORMAL) {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")지음"+"\t대출 가능");
		}else {
			System.out.println(bookNo+"\t"+bookTitle+"\t"+"("+writer+")지음"+"\t상태 이상");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "지음)";
//		msg = msg + ( (state==STATE_NORMAL)? "대출가능" : (state==STATE_BORROWED)? "대출중":"이상해" );
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
