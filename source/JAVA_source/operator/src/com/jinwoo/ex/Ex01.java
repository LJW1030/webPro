package com.jinwoo.ex;

import java.util.Scanner;

public class Ex01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����: ");
		int kor = sc.nextInt();
		System.out.println("���� ����: ");
		int math = sc.nextInt();
		System.out.println("���� ����: ");
		int eng = sc.nextInt();
		int sum = kor+math+eng;
		double avg = sum/3.0;
		System.out.println("����: "+sum);
		System.out.printf("���: %.3f", avg);
		
	}
}
