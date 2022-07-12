package com.jinwoo.ex;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(0) 바위(1) 보(2) !!");
		int you, computer = (int)Math.random()*3;
		you = sc.nextInt();
		if (you==0) {
			System.out.println("Player: 가위");
		}else if(you==1) {
			System.out.println("Player: 바위");
		}else if(you==2) {
			System.out.println("Player: 보자기");
		}else {
			System.out.println("유효하지 않은 값");
			you =3;
		}
		if(you !=3) {
			String msg = (computer==0) ? "computer: 가위" : (computer==1) ? "computer: 바위" : "computer: 보자기";
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
