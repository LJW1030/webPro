package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 수를 입력받아 입력받은 수 ! 계산 (팩토리얼 계산하는 메소드 이용)
public class Ex06_factorial {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("양수를 입력하세요 : ");
			num = sc.nextInt();
		}while(num<=0);
		long result = factorial(num);
		System.out.println("입력하신 "+num+"! = "+result);
	}
	private static long factorial(int num) { // num이 1초과일 경우: num*!(num-1)
			if (num==1) {
				return 1;
			}else {
				return num * factorial(num-1);//재귀적 함수 호출(자기자신을 계속 호출)
			}
		}
//	private static long factorial(int num) {
//		int result = 1;
//		for (int i=num; i>=1; i--) {
//			result *= i;
//		}
//		return result;
//	}
		
}

