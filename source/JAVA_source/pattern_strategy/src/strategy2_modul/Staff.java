package strategy2_modul;

import strategy2_inter.GetSalary;
import strategy2_inter.JobMng;

public class Staff extends Person {

	private String part;
	
	public Staff(String num, String name, String part) {
		super(num, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println(part);
	}
}
