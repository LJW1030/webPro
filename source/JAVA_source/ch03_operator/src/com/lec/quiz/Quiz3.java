package com.lec.quiz;

import java.util.Scanner;

//�� ���� �Է¹޾� �� ���� ������ ����� o�� x�� ���, ù��° ���� �� ū�� ����� o�� x�� ���
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ù��° ���� �Է��ϼ��� : ");
		int su = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("�ι�° ���� �Է��ϼ��� : ");
		int su2 = scanner1.nextInt();
		
		if (su == su2) {
			System.out.println("O");
			}
		else {
			System.out.println("X");
		}
		if (su > su2 ) {
			System.out.println("O");
		}
		else {
			System.out.println("X");
		}
		scanner.close();
		scanner1.close();
	}
		
	}

