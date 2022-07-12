package strategy2_modul;

import strategy2_inter.GetPokcetMoney;
import strategy2_inter.JobStudy;

public class Student extends Person {

	private String ban;
	
	public Student(String num, String name, String ban) {
		super(num, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetPokcetMoney());
	}
	@Override
	public void print() {
		super.print();
		System.out.println(ban);
	}
}
