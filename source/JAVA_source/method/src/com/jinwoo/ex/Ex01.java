package com.jinwoo.ex;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("���ϴ� ������ ��(2~9)");
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
