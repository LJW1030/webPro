package strategy3.modul;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;

public class Staff extends Person {
	
	private String part;
	public Staff(String ID, String name, String part) {
		super(ID, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+part);
	}

}
