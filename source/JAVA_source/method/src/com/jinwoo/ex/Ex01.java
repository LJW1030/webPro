package com.jinwoo.ex;

import java.util.Scanner;

// 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오.
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("원하는 구구단 수(2~9)");
			num = sc.nextInt();
			}while(num<2 || num>9);
		gugudan(num);
	}
	private static void gugudan(int su) {
		for(int i=1; i<10; i++ ) {
			System.out.println(su+" * "+i+" = "+su*i);
		}
	}

}
