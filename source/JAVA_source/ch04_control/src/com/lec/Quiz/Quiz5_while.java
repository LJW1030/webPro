package com.lec.Quiz;

import java.util.Scanner;

// �ϰ� �� ������ ���������� ������ �����ϴ� ���α׷�
public class Quiz5_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer;
		do {
			computer = (int) (Math.random() * 3);
			System.out.println("����(0), ����(1), ��(2) !");
			you = sc.nextInt();
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
				// ����� �� 3���� : ����, �̰��, ���� ; if���� ����� ���� 9����
				if( (you+2)%3 == computer) {
					System.out.println("����� �̰��.");
					break;
				}else if(you == computer) {
					System.out.println("����.");
				}else {
					System.out.println("����� ����.");
				}//if-�������
			}
			}while(true);
		System.out.println("�߰�");
		sc.close();
	}
}
