package com.lec.Quiz;

import java.util.Scanner;

// 0 =< Math.random() <1
// 0 =< Math.random()*3 <3
// (int)(Math.random()*3) : 0, 1, 2 �� �ϳ�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer = (int) (Math.random() * 3);// 0,1,2
		System.out.println("����(0) ����(1) ��(2) !");
		you = sc.nextInt(); // ������ �Է� ����
		if (you == 0) {
			System.out.print("����� ����\t");
		} else if (you == 1) {
			System.out.print("����� ����\t");
		} else if (you == 2) {
			System.out.print("����� ��\t");
		} else {
			System.out.println("����� �߸� �½��ϴ�. ����");
			you = 3; // ������ ���� ����
		}
		if (you != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
			String msg = (computer == 0) ? "���� ����" : (computer == 1) ? "���� ����" : "���� ���ڱ�";
			System.out.println(msg);
			if (you == 0) {
				if (computer == 0) {
					System.out.println("����");
				} else if (computer == 1) {
					System.out.println("��ǻ�Ͱ� �̰��");
				} else if (computer == 2) {
					System.out.println("����� �̰��");
				} // if you=0
			} else if (you == 1) {
				if (computer == 0) {
					System.out.println("����� �̰��");
				} else if (computer == 1) {
					System.out.println("����");
				} else if (computer == 2) {
					System.out.println("��ǻ�Ͱ� �̰��");
				} // if you=1

			} else if (you == 2) {
				if (computer == 0) {
					System.out.println("��ǻ�Ͱ� �̰��");
				} else if (computer == 1) {
					System.out.println("����� �̰��");
				} else if (computer == 2) {
					System.out.println("����");
				}
			} // if you=2
			sc.close();
		}

	}
}
