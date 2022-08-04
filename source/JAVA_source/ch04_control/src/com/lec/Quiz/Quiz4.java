package com.lec.Quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(0) 바위(1) 보(2) !");
		
		int you = sc.nextInt();
		
		if( you == 0) {
			System.out.println("당신은 가위");
		}else if( you == 1) {
			System.out.println("당신은 바위");
		}else if( you == 2) {
			System.out.println("당신은 보");
		}
		sc.close();
	}
}
