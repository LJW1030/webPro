package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		Customer customer = new Customer("홍", "010-0000-9999", "서울", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("김", "010-8888-7777", "2022-09-01", "개발팀");
		Person person = new Person("이", "010-5555-5555");
		Person[] personArr = {customer, staff, person};
		for( int i=0; i<personArr.length; i++) { //일반for문
			System.out.println(personArr[i].infoString());
		}
		for(Person p : personArr) { // 확장for문; 배열 0~끝방까지 infoString()
			System.out.println(p.infoString());
		}
		// buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) { // 변수p가 Customer형 객체(instance)인가?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy는 Customer만 가능합니다");
			}
		}
	}
}
