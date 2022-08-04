package com.lec.ex2_thread;

public class TargetExTestMain {

	public static void main(String[] args) {
		Thread t1 = new TargetEx01("A");
		Thread t2 = new TargetEx02();
		t2.setName("B");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main ÇÔ¼ö ³¡");
		
	}
}
