package com.ex.ch02.ex3;

import lombok.Data;

@Data
public class ExamImpl {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int computer;
	public int total() {
		return kor+eng+mat+computer;
	}
	public double avg() {
		return total()/4.0;
	}
}
