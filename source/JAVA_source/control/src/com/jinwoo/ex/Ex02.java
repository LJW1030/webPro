package com.jinwoo.ex;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����(0) ����(1) ��(2) !!");
		int you, computer = (int)Math.random()*3;
		you = sc.nextInt();
		if (you==0) {
			System.out.println("Player: ����");
		}else if(you==1) {
			System.out.println("Player: ����");
		}else if(you==2) {
			System.out.println("Player: ���ڱ�");
		}else {
			System.out.println("��ȿ���� ���� ��");
			you =3;
		}
		if(you !=3) {
			String msg = (computer==0) ? "computer: ����" : (computer==1) ? "computer: ����" : "computer: ���ڱ�";
			System.out.println(msg);
		if( (you+1)%3 == computer) {
			System.out.println("LOSE");
		}else if(you == computer ) {
			System.out.println("DRAW");
		}else {
			System.out.println("WIN");
		}
	}
	}
}
