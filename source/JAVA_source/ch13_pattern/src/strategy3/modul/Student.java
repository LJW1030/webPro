package strategy3.modul;

import strategy3.interfaces.GetStudentPay;
import strategy3.interfaces.JobStudy;

public class Student extends Person {
	
	private String ban;
	public Student(String ID, String name, String ban) {
		super(ID, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+ban);		
	}
	
}
