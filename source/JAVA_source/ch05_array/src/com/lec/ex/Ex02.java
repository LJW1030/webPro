package com.lec.ex;
// 일반 for문 vs.확장 for문(배열 출력)
public class Ex02 {
	public static void main(String[] args) {
		int[] arr = new int[3]; // 배열이  0 0 0으로 초기화 {0,0,0}
		for(int idx=0; idx<arr.length; idx++) { // 일반 for문 이용한 출력
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
	}
		for(int temp : arr) { // 확장 for문을 이용한 출력
			System.out.println(temp);
		}
		for(int i=0; i<arr.length; i++) { // 일반 for문을 이용한 배열 수정
			arr[i] =5;
		}
		for(int temp : arr) {
			temp = 9;
		}
		for(int temp : arr) { // 값 출력은 확장 for문, 값 수정은 일반 for문
			System.out.println(temp);
		}
	}
}
