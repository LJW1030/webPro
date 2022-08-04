package com.lec.Quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		int kor = sc.nextInt();
		System.out.println("영어 점수 : ");
		int eng = sc.nextInt();
		System.out.println("수학 점수 : ");
		int math = sc.nextInt();
		
		double average = ((double)kor+eng+math)/3;
		System.out.printf("평균 점수는 : %.2f \n", average);
		if (kor>=average) {
			System.out.println("국어 점수는 평균 이상입니다");
		} else {
			System.out.println("국어 점수는 평균 이하입니다");
			}
		if (eng>=average) {
			System.out.println("영어 점수는 평균 이상입니다");
		} else {
			System.out.println("영어 점수는 평균 이하입니다");
			}
		if (math>=average) {
			System.out.println("수학 점수는 평균 이상입니다");
		} else {
			System.out.println("수학 점수는 평균 이하입니다");
			}
		sc.close();
		
	}

}
