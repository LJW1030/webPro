package com.lec.quiz;
// 입력 받은 수가 짝수인지 홀수인지 출력
public class Quiz2 {
	public static void main(String[] args) {
		int i = 28;
		String result;
		result = (i%2 == 0) ? "짝수" : "홀수";
		System.out.println(result);
	}
}
