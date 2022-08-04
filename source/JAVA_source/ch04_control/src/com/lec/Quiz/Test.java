package com.lec.Quiz;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 몇 단을 실행할까요?");
		int num = sc.nextInt();
		if(num>=1 && num<10) {
		for(int i=1; i<10; i++) {
			System.out.println(num+" * "+i+" = "+num*i);
		}
		}else {
			System.out.println("유효하지 않은 값입니다.");
		}
			
		sc.close();
	}
}
