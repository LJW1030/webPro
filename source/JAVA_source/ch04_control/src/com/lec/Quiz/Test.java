package com.lec.Quiz;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �� ���� �����ұ��?");
		int num = sc.nextInt();
		if(num>=1 && num<10) {
		for(int i=1; i<10; i++) {
			System.out.println(num+" * "+i+" = "+num*i);
		}
		}else {
			System.out.println("��ȿ���� ���� ���Դϴ�.");
		}
			
		sc.close();
	}
}
