package com.lec.ex3_account;
/*데이터(속성, 멤버변수, 인스턴스변수) : 계좌번호(accountNo:String), 예금주(ownerName:String), 잔액(balance:long)
   기능(메소드) : 예금하다(void deposit(int)), 인출하다(int withdraw(int)), 잔액조회(long infoPrint()) 
  사용:Account a = new Account("100-1","홍길동"); / Account("100-2","신길동",2200000000)*/
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {} // 디폴트 생성자
	public Account(String accountNo, String ownerName) { // 생성자 역할 : 데이터 초기화
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안 갖고 오셨어요\n", ownerName, accountNo);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance   = balance;
		System.out.printf("%s(%s)님 %d원 입금 계좌 개설 감사\n", ownerName, accountNo, balance);
	}
	// 메소드 예금하다(void deposit(int)), 인출하다(int withdraw(int)), 잔액조회(String infoPrint()) 
	public void deposit(int money) { // 예금은 양수 money가 들어오면 예금처리
		if(money>=0) {
			balance += money; //balance = balance + money;
		}else {
			System.out.println("떼끼");
		}
	}
	public void withdraw(int money) {
		if(money<=balance) {
			balance -= money; // balance = balance-money;
		}else {
			System.out.println(ownerName+"잔액이 부족하여 인출이 불가합니다");
		}
	}
	public String infoPrint() { // 홍길동(100-1)님 잔액 : 1000원
		return String.format("%s(%s)님 잔액 : %d원\n", ownerName, accountNo, balance);
		//return ownerName + "(" + accountNo + ")" + "님 잔액 : " + balance + "원";
	}
	// setter & getter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}

















