package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹޾� �Է¹��� �� ! ��� (���丮�� ����ϴ� �޼ҵ� �̿�)
public class Ex06_factorial {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("����� �Է��ϼ��� : ");
			num = sc.nextInt();
		}while(num<=0);
		long result = factorial(num);
		System.out.println("�Է��Ͻ� "+num+"! = "+result);
	}
	private static long factorial(int num) { // num�� 1�ʰ��� ���: num*!(num-1)
			if (num==1) {
				return 1;
			}else {
				return num * factorial(num-1);//����� �Լ� ȣ��(�ڱ��ڽ��� ��� ȣ��)
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

