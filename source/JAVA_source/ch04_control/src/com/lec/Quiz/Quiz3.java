package com.lec.Quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� : ");
		int kor = sc.nextInt();
		System.out.println("���� ���� : ");
		int eng = sc.nextInt();
		System.out.println("���� ���� : ");
		int math = sc.nextInt();
		
		double average = ((double)kor+eng+math)/3;
		System.out.printf("��� ������ : %.2f \n", average);
		if (kor>=average) {
			System.out.println("���� ������ ��� �̻��Դϴ�");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�");
			}
		if (eng>=average) {
			System.out.println("���� ������ ��� �̻��Դϴ�");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�");
			}
		if (math>=average) {
			System.out.println("���� ������ ��� �̻��Դϴ�");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�");
			}
		sc.close();
		
	}

}
