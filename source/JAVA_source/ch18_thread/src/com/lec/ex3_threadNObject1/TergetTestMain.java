package com.lec.ex3_threadNObject1;

public class TergetTestMain {

	public static void main(String[] args) {
		TargetEx t1 = new TargetEx();
		Thread threadA = new Thread(t1, "A");
		Thread threadB = new Thread(t1, "B");
		threadA.start();
		threadB.start();
		System.out.println("main ÇÔ¼ö ³¡");
	}
}
