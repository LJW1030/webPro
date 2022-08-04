package com.lec.ex3_student;

public class StudentDto {

	private int rank;
	private int mno;
	private String mname;
	private int sno;
	private String sname;
	private int score;
	private int expel;
	public StudentDto() {}
	public StudentDto(String sname, String mname,  int score) {
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}
	
	public StudentDto(String sname, String mname, int score,int sno ) {
		this.mname = mname;
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}
	public StudentDto(int rank, int mno, String mname, int sno, String sname, int score) {
		this.rank = rank;
		this.mno = mno;
		this.mname = mname;
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}
	@Override
	public String toString() {
		if(rank!=0) {
			return rank+"µî\t"+sname+"\t"+mname+"\t"+score;
		}else {
			return sno+"\t"+sname+"\t"+mname+"\t"+score;
		}
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExpel() {
		return expel;
	}
	public void setExpel(int expel) {
		this.expel = expel;
	}
	
	
	
}
