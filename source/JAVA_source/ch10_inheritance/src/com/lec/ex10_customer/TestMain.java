package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		Customer customer = new Customer("ȫ", "010-0000-9999", "����", "1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("��", "010-8888-7777", "2022-09-01", "������");
		Person person = new Person("��", "010-5555-5555");
		Person[] personArr = {customer, staff, person};
		for( int i=0; i<personArr.length; i++) { //�Ϲ�for��
			System.out.println(personArr[i].infoString());
		}
		for(Person p : personArr) { // Ȯ��for��; �迭 0~������� infoString()
			System.out.println(p.infoString());
		}
		// buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) { // ����p�� Customer�� ��ü(instance)�ΰ�?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy�� Customer�� �����մϴ�");
			}
		}
	}
}
