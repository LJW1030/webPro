package com.lec.quiz;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int you, computer = (int)(Math.random()*3);
		System.out.println("가위(0) 바위(1) 보(2)");
		you = sc.nextInt();
		if(you==0) {
			System.out.println("당신은 가위");
		}else if(you==1) {
			System.out.println("당신은 바위");
		}else if(you==2) {
			System.out.println("당신은 보자기");
		}else {
			System.out.println("당신의 오류");
			you=3;
		}
		if (you !=3) {
			String msg = (computer==0) ? "컴이 가위" :(computer==1) ? "컴이 바위" : "컴이 보자기" ;
			System.out.println(msg);
		}
		
	}
}
