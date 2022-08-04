package com.lec.ex10_customer;
// name, tel, address, sum, point, date, vip
// Customer c = new Customer("홍", "010", "설", "1995-12-12")
public class Customer extends Person{
	private String address;
	private int sum; // 구매누적금액
	private int point; // 포인트(구매마다 5%적립)
	private String date; // 기념일(Date타입 될 예정)
	private boolean vip; // true면 vip, false면 일반
	public Customer(String name, String tel, String address, String date) {
		super(name, tel); // 첫번째 라인에 와야함
		this.address = address;
		this.date = date;
		point = 1000; // 새 고객에게는 1000포인트 자동 부여
//		sum = 0; 기본값 int(sum)=0, boolean(vip)=false 이므로 기입 x
//		vip = false;
		System.out.println(name+"님 감사감사. 포인트 1000점을 선물로 드립니다");
	}
	public void buy(int price) {// c.buy(10000)
		sum += price;
		int tempPoint = (int)(price*0.05);
		point += tempPoint;
		System.out.println(getName()+"님 감사. 이번 구매 포인트 : "+tempPoint+"P 추가되어 총 누적 포인트 : "+point);
		if (sum>=1000000 && vip==false) {
			vip = true; // 구매누적 금액이 100만원 이상시 vip
			System.out.println(getName()+"님 VIP고객으로 업그레이드 되셨습니다.");
		}//if
	}//buy
	// 1. c.print() vs 2. sysout(c.infoString()) vs 3. sysout(c)
	@Override // @ : 어노테이션
	public String infoString() {
		return super.infoString() + " [주소]" + address + " [포인트]" + point + " [누적금액]" + sum;
	}
}
