package com.lec.Quiz;

public class Quiz4 {

	public static void main(String[] args) {
		int money = 2680;
		int [] coinUnit = {500,100,50,10};
		for(int i=0 ; i<coinUnit.length ; i++) {
			System.out.println(coinUnit[i]+"��¥�� ����"+(money/coinUnit[i])+"��");
			money %= coinUnit[i];
		}
	}
}
	

