package com.jinwoo.ex;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���: ");
		int age = sc.nextInt();
		System.out.println((age>=8 && age<=19) ? "�л� ����" :"���� ��� �ƴ�");
	}
}
