package com.jinwoo.ex;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.println((age>=8 && age<=19) ? "학생 할인" :"할인 대상 아님");
	}
}
