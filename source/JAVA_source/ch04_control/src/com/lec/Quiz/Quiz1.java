package com.lec.Quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ� : ");
		int num = sc.nextInt();
		
		if (num>=0) {
			System.out.println("�Է��� ���� ������ "+num);
		}else {
			System.out.println("�Է��� ���� ������ "+-num);
		}
			
		sc.close();
	}

}
