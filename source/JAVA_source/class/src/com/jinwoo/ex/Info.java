package com.jinwoo.ex;

public class Info {

	private String name;
	private int age;
	private char gender;
	public Info() {}
	public Info(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void info() {
		System.out.println("이름은 "+name+" 나이는 "+age+" 성별은 "+gender);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
