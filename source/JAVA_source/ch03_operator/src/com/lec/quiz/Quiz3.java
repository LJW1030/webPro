package com.lec.quiz;

import java.util.Scanner;

//두 수를 입력받아 두 수가 같은지 결과를 o나 x로 출력, 첫번째 수가 더 큰지 결과를 o나 x로 출력
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 수를 입력하세요 : ");
		int su = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("두번째 수를 입력하세요 : ");
		int su2 = scanner1.nextInt();
		
		if (su == su2) {
			System.out.println("O");
			}
		else {
			System.out.println("X");
		}
		if (su > su2 ) {
			System.out.println("O");
		}
		else {
			System.out.println("X");
		}
		scanner.close();
		scanner1.close();
	}
		
	}

