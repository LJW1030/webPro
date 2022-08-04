package com.lec.condition;

public class Ex03_swith {

	public static void main(String[] args) {
		int num1 = 4;
		switch(num1) { // 정수형, 문자형 ,문자열만 가능
			case 1 : System.out.println("1 입니다"); break;
			case 2 : System.out.println("2 입니다"); break;
			case 3 : System.out.println("3 입니다"); break;
			default : System.out.println("그 외 수입니다");
//		if (num1==1) {
//			System.out.println("1 입니다");
//		}else if (num1==2) {
//			System.out.println("2 입니다");
//		}else if (num1==3) {
//			System.out.println("3 입니다");
//		}else {
//			System.out.println("그 외 수입니다");
//		}
		}
	}
}
	

