package com.lec.ex0_janmuri;
class PersonInfo{
	private String name;
	private int age;
	public PersonInfo() {}
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.printf("ÀÌ¸§=%s\t³ªÀÌ=%d\n", name, age);
	}
	
}
public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("È«±æµ¿",22),
				               new PersonInfo("±è±æµ¿",25)};
		for(PersonInfo p : person) {
			p.print();
		}
		for(int idx=0; idx<person.length; idx++) {
			person[idx].print();
		}
	}

}
