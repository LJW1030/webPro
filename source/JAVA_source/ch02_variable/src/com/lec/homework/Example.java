package com.lec.homework;

public class Example {
	public static void main(String[] args) {
		int korean = 95;
		int english = 100;
		int math = 98;
		
		System.out.println("korean="+korean);
		System.out.println("english="+english);
		System.out.println("math="+math);
		
		int total = korean+english+math;
		double average = ((double)total)/3;
		
		System.out.println(total);
		System.out.println(average);
		
	}
}
