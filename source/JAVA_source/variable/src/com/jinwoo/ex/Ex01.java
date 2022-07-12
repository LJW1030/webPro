package com.jinwoo.ex;

public class Ex01 {

	public static void main(String[] args) {
		int kor = 95;
		int eng = 90;
		int math = 96;
		int sum = kor+eng+math;
		double avg = sum/3.0;
		System.out.printf("국어점수: %d\n영어점수: %d\n수학점수: %d\n합계: %d\n평균: %.2f", kor, eng, math, sum, avg);
	}
}
