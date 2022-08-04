package com.lec.quiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int su;
		do {
		System.out.println("원하는 구구단 단수를 입력하시오 : ");
		su = sc.nextInt();
		}while(su>9 || su<2);
		gugudan(su);
		
		
	}
	private static void gugudan(int num) {
		for( int i=1; i<10; i++) {
			System.out.println(num+" * "+i+" = "+num*i);
	}
}
}
