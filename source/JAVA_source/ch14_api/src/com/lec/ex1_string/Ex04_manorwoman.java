package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_manorwoman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		
			System.out.println("�ֹι�ȣ �Է��Ͻÿ�");
			fn = sc.next();
			if(fn.charAt(7)=='1') {
				System.out.println("����");
			}else if(fn.charAt(7)=='2') {
				System.out.println("����");
			}
		sc.close();
	}
}
