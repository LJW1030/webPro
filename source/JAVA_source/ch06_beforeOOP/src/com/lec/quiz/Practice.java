package com.lec.quiz;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int you, computer = (int)(Math.random()*3);
		System.out.println("����(0) ����(1) ��(2)");
		you = sc.nextInt();
		if(you==0) {
			System.out.println("����� ����");
		}else if(you==1) {
			System.out.println("����� ����");
		}else if(you==2) {
			System.out.println("����� ���ڱ�");
		}else {
			System.out.println("����� ����");
			you=3;
		}
		if (you !=3) {
			String msg = (computer==0) ? "���� ����" :(computer==1) ? "���� ����" : "���� ���ڱ�" ;
			System.out.println(msg);
		}
		
	}
}
