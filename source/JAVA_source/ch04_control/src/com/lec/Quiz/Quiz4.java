package com.lec.Quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����(0) ����(1) ��(2) !");
		
		int you = sc.nextInt();
		
		if( you == 0) {
			System.out.println("����� ����");
		}else if( you == 1) {
			System.out.println("����� ����");
		}else if( you == 2) {
			System.out.println("����� ��");
		}
		sc.close();
	}
}
