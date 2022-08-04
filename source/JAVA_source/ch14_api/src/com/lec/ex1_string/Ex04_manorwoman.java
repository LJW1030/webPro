package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_manorwoman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		
			System.out.println("주민번호 입력하시오");
			fn = sc.next();
			if(fn.charAt(7)=='1') {
				System.out.println("남자");
			}else if(fn.charAt(7)=='2') {
				System.out.println("여자");
			}
		sc.close();
	}
}
