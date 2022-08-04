package com.lec.Quiz;

import java.util.Scanner;

// 니가 질 때까지 가위바위보 게임을 지속하는 프로그램
public class Quiz5_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer;
		do {
			computer = (int) (Math.random() * 3);
			System.out.println("가위(0), 바위(1), 보(2) !");
			you = sc.nextInt();
			if (you == 0) {
				System.out.print("당신은 가위\t");
			} else if (you == 1) {
				System.out.print("당신은 바위\t");
			} else if (you == 2) {
				System.out.print("당신은 보\t");
			} else {
				System.out.println("당신은 잘못 냈습니다. 바이");
				you = 3; // 끝내기 위한 조건
			}
			if (you != 3) { // 컴퓨터가 낸 것과 승패 출력
				String msg = (computer == 0) ? "컴이 가위" : (computer == 1) ? "컴이 바위" : "컴이 보자기";
				System.out.println(msg);
				// 경우의 수 3가지 : 졌다, 이겼다, 비겼다 ; if절은 경우의 수가 9가지
				if( (you+2)%3 == computer) {
					System.out.println("당신이 이겼다.");
					break;
				}else if(you == computer) {
					System.out.println("비겼다.");
				}else {
					System.out.println("당신이 졌다.");
				}//if-승패출력
			}
			}while(true);
		System.out.println("잘가");
		sc.close();
	}
}
