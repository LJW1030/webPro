package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		;
		System.out.println("���ϴ� �� : ");
		int num = sc.nextInt();
		System.out.println("���� : " + abs(num));
		sc.close();
	}

	private static int abs(int num) {
		int result = num > 0 ? num : -num;
		return result;
	}
}
