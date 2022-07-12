package com.jinwoo.ex;

import java.util.Scanner;

public class Ex01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수: ");
		int kor = sc.nextInt();
		System.out.println("수학 점수: ");
		int math = sc.nextInt();
		System.out.println("영어 점수: ");
		int eng = sc.nextInt();
		int sum = kor+math+eng;
		double avg = sum/3.0;
		System.out.println("총점: "+sum);
		System.out.printf("평균: %.3f", avg);
		
	}
}
