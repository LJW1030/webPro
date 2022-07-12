package com.jinwoo.ex;

public class Ex03 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int total = 0, min=999;
		int avg = 0, max=000;
		for(int i=0; i<arr.length; i++) {
			total += arr[i];
			avg = total/8;
			if(min>arr[i]) {
				min = arr[i];
			}if(max<arr[i]) {
				max = arr[i];
			}
		}System.out.println(total);
		System.out.println(avg);
		System.out.println(min);
		System.out.println(max);
		
	
			
	}
}
