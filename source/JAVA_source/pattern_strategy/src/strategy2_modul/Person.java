package strategy2_modul;

import strategy2_inter.*;

public class Person {

	private IJob job;
	private IGet get;
	private String name;
	private String num;
	public Person(String num, String name) {
		this.name = name;
		this.num = num;
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.print(num+"\t"+name+"\t");
	}
	public void setJob(IJob job) {
		this.job = job;
	}
	public void setGet(IGet get) {
		this.get = get;
	}
	
	
}
