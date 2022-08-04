package com.lec.ex13_person;

public class Gangsa extends Person{

	public static int j = 1;
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		int num = j++;
		setNo("lec"+num);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(°ú¸ñ)"+subject);
	}
}
