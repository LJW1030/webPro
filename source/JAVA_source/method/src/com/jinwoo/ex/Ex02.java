package com.jinwoo.ex;

import java.util.Scanner;

//사용자로부터 수를 입력받아 절대값을 출력하는 로직을 구현하시오 
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("절대값을 원하는 수를 입력하시오.");
		int num = sc.nextInt();
		System.out.println("절대값은 "+abs(num));
		
	}
	private static int abs(int su) {
		return su>=0 ? su : -su;
	}
}
