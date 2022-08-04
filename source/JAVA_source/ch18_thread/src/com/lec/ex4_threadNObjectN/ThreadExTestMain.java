package com.lec.ex4_threadNObjectN;

public class ThreadExTestMain {

	public static void main(String[] args) {
		Thread threadA = new ThreadEx("A");
		Thread threadB = new ThreadEx("B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		System.out.println("A�� num : "+((ThreadEx) threadA).getNum());
		System.out.println("B�� num : "+((ThreadEx) threadB).getNum());
	}
}
