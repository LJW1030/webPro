package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorche= new Car(); // myPorche�� ��ü���� = instance
		myPorche.setColor("red");// myPorche.color = "red";
		System.out.println(myPorche.getColor()+""+"��ⷮ:"+myPorche.getCc()+"�ӵ�:"+myPorche.getSpeed());
		myPorche.drive();
		myPorche.park();
		myPorche.race();
		System.out.println(myPorche.getSpeed());
		Car yourPorche= new Car();
		yourPorche.setColor("blue");
		yourPorche.setCc(1800);
		yourPorche.drive();
	}
}
