package com.lec.ex;
// Class : ������(�Ӽ�, �ν��Ͻ�����)�� �޼ҵ�(���, setter, getter)
// Car c = new Car()
// c.park()
public class Car {
	private String color; // ����
	private int cc; // ��ⷮ
	private int speed; // �ӵ�
	public void drive() {
		speed = 60;
		System.out.println(color+"�� ���� "+cc+" cc�� �����Ѵ�. ���� �ӵ� : "+speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color+ "�� ���� �����Ѵ�. ���� �ӵ� : "+speed);
	
	}
	public void race() {
		speed = 120;
		System.out.println(color+ "�� ���� �����Ѵ�. ���� �ӵ� : "+speed);
	}
	//setter & getter (color, cc, speed)
	//myPorche.methodNamed("red") set+color => setColor
	public void setColor(String color) { // myPorche.setColor("red")
		this.color = color;
	}
	public void setCc(int cc) { // myPorche.setCc(1500)
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// myPorche.getColor()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
}
