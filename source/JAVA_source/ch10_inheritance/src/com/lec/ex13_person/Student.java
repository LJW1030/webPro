package com.lec.ex13_person;

public class Student extends Person{
	private String ban;
	public static int i=1;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		int num = i++;
		setNo("St10"+num);
	}
	@Override
	public void print() {
		super.print();
	System.out.println("\t(¹Ý)"+ban);
	}
	
}
