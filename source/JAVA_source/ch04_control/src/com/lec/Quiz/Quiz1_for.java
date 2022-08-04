package com.lec.Quiz;
// 1부터 10까지의 누적곱
public class Quiz1_for {

	public static void main(String[] args) {
		int tot = 1;
		for( int i=1; i<=10; i++) {	
		tot *= i;
		}
		System.out.println("1부터 10까지 누적곱은 "+tot);
	}
}
