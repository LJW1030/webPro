package com.lec.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	
	private String BookNo;     // å ��ȣ
	private String bookTitle;  // å �̸�
	private String writer;     // ����
	private String borrower;   // ������
 	private Date checkoutDate; // ������
	private byte state;        // ������(1), ���Ⱑ��(0)
	
	public BookLib(String bookNo, String bootTitle, String writer) {
		this.BookNo = bookNo;
		this.bookTitle = bootTitle;
		this.writer = writer;
	}
	// BookLib book = new BookLib("89��-01","java","ȫ�浿");
	// book.checkOut("�ű浿") : �������� Ȯ�� -> ������� -> �����������
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == STATE_BORROWED) {
			throw new Exception(bookTitle + "������ <������> �Դϴ�."); // ������ ���� �߻�
		}
		this.borrower = borrower;
		checkoutDate = new Date();
		state = STATE_BORROWED;
		// java ������ ����Ǿ����ϴ�. ������: �ű浿. ������:2022-4-4. 2���̳��� �ݳ��ϼ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println("\""+bookTitle+"\" ������ ����Ǿ����ϴ�.");
		System.out.println("������ : "+borrower+" / ������ : "+sdf.format(checkoutDate)+" / 2�ֳ��� �ݳ��ϼ���.");
		}
	// book.checkIn() : �������� Ȯ�� -> ��ü���� Ȯ�� -> (if.��ü�Ǿ��� ��� ��ü�� ����(Y/N)) -> �ݳ����� -> ������� 
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle +"������ �������� �ƴմϴ�");
		}
		// ��ü���� Ȯ�� checkoutDate = ������� 14���̳����� ����
		Date now = new Date();
		long diff = now.getTime() - checkoutDate.getTime(); // ����������� ��������� �и�����
		long day = diff/(1000*60*60*24);
		if(day > 14) { // ��ü�� ���
			System.out.println("��ü��� ���� 200�� �ΰ��˴ϴ�. ���ž��� ��ü��� "+(day-14)*200);
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�Ḧ ���̽��ϱ�? (Y/N)");
			if(! sc.next().equalsIgnoreCase("y")) { // y�� �Է����� ����
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�. ��ü�Ḧ �����ϼ���");
				return;
			}
		}
		//�ݳ�����
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"������ <�ݳ�> �Ǿ����ϴ�.");
	}
	//sysout(book) -> å��ȣ:89��-01 å�̸�:java ����:ȫ�浿 ���Ⱑ��
	//			   -> å��ȣ:89��-01 å�̸�:java ����:ȫ�浿 ������(�ݳ�������:2022-4-4(��))
	@Override
	public String toString() {
		String msg = "å ��ȣ : "+BookNo+"\tå �̸� : "+bookTitle+"\t���� : "+writer;
		msg += (state == STATE_NORMAL) ? "\t���� ���� " : "\t���� ��";
		if(state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("(������ : yyyy-MM-dd(E))");
			msg += sdf.format(checkoutDate);
		}
		return msg;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
}
