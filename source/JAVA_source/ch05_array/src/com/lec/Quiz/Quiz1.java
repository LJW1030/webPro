package com.lec.Quiz;

public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int total = 0;
		for(int idx=0; idx<arr.length; idx++) {
			total += arr[idx];
		}
		System.out.println("배열에 담긴 값의 합계는 "+ total);
	}
}
