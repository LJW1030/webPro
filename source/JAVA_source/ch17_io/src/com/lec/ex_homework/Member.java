package com.lec.ex_homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

	private String name;
	private String tel;
	private Date date;
	private String address;

	public Member(String name, String tel, Date date, String address) {
		this.name = name;
		this.tel = tel;
		this.date = date;
		this.address = address;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd »ý");
		return name+"\t"+tel+"\t"+sdf.format(date)+"\t"+address;
	}
}
