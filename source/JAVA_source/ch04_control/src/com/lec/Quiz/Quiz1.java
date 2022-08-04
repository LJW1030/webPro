package com.lec.Quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		
		if (num>=0) {
			System.out.println("입력한 수의 절댓값은 "+num);
		}else {
			System.out.println("입력한 수의 절댓값은 "+-num);
		}
			
		sc.close();
	}

}
