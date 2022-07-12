package com.jinwoo.ex2;

public class BoxMain {
	public static void main(String[] args) {
		Box b = new Box(5,10);
		Box r = new Box(5,8,15);
		
		b.print();
		r.print();
		System.out.println("넓이는 "+b.getvolume());
		System.out.println("부피는 "+r.getvolume());
	}
}
