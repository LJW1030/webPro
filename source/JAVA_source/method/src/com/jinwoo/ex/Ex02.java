package com.jinwoo.ex;

import java.util.Scanner;

//����ڷκ��� ���� �Է¹޾� ���밪�� ����ϴ� ������ �����Ͻÿ� 
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���밪�� ���ϴ� ���� �Է��Ͻÿ�.");
		int num = sc.nextInt();
		System.out.println("���밪�� "+abs(num));
		
	}
	private static int abs(int su) {
		return su>=0 ? su : -su;
	}
}
