package com.lec.ex2_human;
// Man Kim - new Man(22, 160, 50,5, "010-0000-0000");
//Man Kim - new Man(22, 160, 50,5);
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	
	public Man() {} // ����Ʈ ������ �Լ�, ������ �Լ��� ����Ÿ�� ����
	public Man(int age) {
			this.age =age;
		}
	
//	public Man(int height) {
//		this.height = height;
//	}
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");
	}
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");
	}//setter & getter(age, height, weight, phoneNum)
	public double calculateBMI() {
		double result = weight / ((height/100.0)*(height/100.0));
		return result;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
}
