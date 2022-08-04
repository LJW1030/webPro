package strategy3.modul;

import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;

public abstract class Person {
	private IJob job;
	private IGet get;
	private String ID;
	private String name;
	public Person(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	public void print() {
		System.out.print(ID+"\t"+name);
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IJob getJob() {
		return job;
	}
	public void setJob(IJob job) {
		this.job = job;
	}
	public IGet getGet() {
		return get;
	}
	public void setGet(IGet get) {
		this.get = get;
	}
	
	
}
