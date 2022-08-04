package com.lec.ex13_person;

public class Staff extends Person{
	
	public static int k=1;
	private String department;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		int num = k++;
		setNo("staff"+num);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(ºÎ¼­)"+department);
	}
	
}
