package com.lec.Quiz;

public class Quiz3 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int total = 0;
		int avg = 1;
		for(int i=0; i<arr.length; i++) {
			total += arr[i];
		}System.out.println("배열의 합계는 "+total);
		for(int j=0; j<arr.length; j++) {
			avg = total/arr.length;
		}System.out.println("배열의 평균은 "+avg);
		int min = 999, mini =0;
		int max = 000, maxi =0;
		for(int i=0; i<arr.length; i++) {
			if( min > arr[i]) {
				min = arr[i];
				mini = i;
			}if( max < arr[i]) {
				max = arr[i];
				maxi = i;
			} 
		}System.out.println("최댓값은 "+arr[maxi]);
		System.out.println("최소값은 "+arr[mini]);
	}
}
