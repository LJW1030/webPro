package strategy2_modul;

import strategy2_inter.GetSalary;
import strategy2_inter.JobLec;

public class Teacher extends Person {

	private String subject;
	
	public Teacher(String num, String name, String subject) {
		super(num, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println(subject);
	}
}
