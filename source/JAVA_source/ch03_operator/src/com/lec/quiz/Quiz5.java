package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ����");
		int korean = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("���� ����");
		int english = scanner.nextInt();
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("���� ����");
		int math = scanner.nextInt();
		
		int total =(korean+english+math);
		System.out.printf("����=%d\n ",total);
		
		double average = ((double)total)/3;
		System.out.printf("���=%.2f ",average);
			
		scanner.close();
		scanner1.close();
		scanner2.close();
	}
}
