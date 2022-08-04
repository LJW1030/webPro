package com.lec.student2;

public class Student {
public static int count=0;
	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	public Student() {}
	public Student(String name, int kor, int eng, int math) {
		num = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		sum = kor+eng+math;
		avg = sum/3.0;
		
	}
	public void print() {
		System.out.println(num+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+avg);
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}
}
