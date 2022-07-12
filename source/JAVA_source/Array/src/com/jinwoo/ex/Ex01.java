package com.jinwoo.ex;
//배열에 담긴 값의 합
public class Ex01 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50};
		int total = 0;
		for( int i=0; i<arr.length; i++) {
			total += arr[i];
		}System.out.println(total);

	}

}
