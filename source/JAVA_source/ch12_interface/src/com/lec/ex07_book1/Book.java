package com.lec.ex07_book1;
// Book b = new book("890��-101-1��","java","ȫ�浿")
public class Book implements ILendable {
	
	private String bookNo; // å��ȣ 
	private String bookTitle; // å����
	private String writer;    // ����
 	private String borrower;  // ������
 	private String checkOutDate; // ������
 	private byte state;          // �������; ������(1),���Ⱑ��(0)
 	
	public Book(String requestNo, String bookTitle, String writer) {
		this.bookNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL;
	}//b.checkOut("�ű浿","03-23"); ���� : ����Ȯ���ؼ� �������̸� �ߴ�, ���Ⱑ���̸� ����ó��
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { // �������̸� �޼��� ��� �� ��
			System.out.println(bookTitle+" ������ ������ �Դϴ�.");
			return;
		}// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ������ ���·� ��ȯ
		System.out.println(bookTitle+" ������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : "+borrower+"\t������ : "+checkOutDate);
		}
	// b.checkIn(); �ݳ� : state Ȯ���ؼ� ���Ⱑ��(0)�̸� �ߴ�, ������(1)�̸� �ݳ�����
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+" ������ ���� ���� �ƴմϴ�. ���ܴ�");
			return;
		}
		// state�� 1�̶� �ݳ�ó�� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle+" ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
	}
	// b.printState() => 890��-101-1�� java(ȫ�浿) ������
	@Override
	public void printState() {
		if(state==STATE_NORMAL) {
			System.out.println(bookNo + "\t" +bookTitle + "(" + writer+"����) ���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(bookNo + "\t" +bookTitle + "(" + writer+"����) ������");
		}else {
			System.out.println(bookNo + "\t" +bookTitle + "(" + writer+"����) �̻���");
		}
//		String msg = bookNo + "\t" +bookTitle + "(" + writer+"����)";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : (state==STATE_BORROWED) ? "������" : "�̻���");
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
