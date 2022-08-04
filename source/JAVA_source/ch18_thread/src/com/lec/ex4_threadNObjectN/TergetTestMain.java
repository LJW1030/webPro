package com.lec.ex4_threadNObjectN;

public class TergetTestMain {

	public static void main(String[] args) {
		TargetEx t1 = new TargetEx();
		TargetEx t2 = new TargetEx();
		Thread threadA = new Thread(t1, "A");
		Thread threadB = new Thread(t2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {	}
		System.out.println("target1의 num : "+t1.getNum());
		System.out.println("target2의 num : "+t2.getNum());
		System.out.println("main 함수 끝");
	}
}
