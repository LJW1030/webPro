package strategy3.modul;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobLec;

public class Lecturer extends Person {

	private String subject;
	public Lecturer(String ID, String name, String subject) {
		super(ID, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+subject);
	}

}
