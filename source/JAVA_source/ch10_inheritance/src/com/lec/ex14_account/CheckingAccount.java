package com.lec.ex14_account;
//CheckingAccoount a2 = new CheckingAccount("11-11","ȫ�浿","1111-1111-2222-3333")
public class CheckingAccount extends Account {
	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		
	}
	// a2.pay("1111-1111-2222-3333",1000);
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { // �ùٸ� ī�� ��ȣ���� Ȯ��
			if(getBalance() >= amount) { // ���Ұ�������(�ܾ��� ������ �ݾ� �̻�)
				setBalance(getBalance()-amount); // balance = balance - amount;
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ� %d�� ���ҽ��ϴ�\n", getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s) �ܾ� %d������ %d�� ���� �Ұ��մϴ�\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		}else {
			System.out.println("�ùٸ� ī�� ��ȣ�� �Է��ϼ���");
		}// if
	}// main
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
