package com.lec.ex1_runnable;

public class TargetExTestMain {

	public static void main(String[] args) {
		Runnable t1 = new TargetEx01();
		Runnable t2 = new TargetEx02();
		//TargetEx02 t2 = new TargetEx02();
		// "A"라는 이름의 스레드 생성 - t1.run() 실행
		Thread threadA = new Thread(t1, "A");
		// "B"라는 이름의 스레드 생성 - t2.run() 실행
		Thread threadB = new Thread(t2, "B");
		threadA.start();
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("--나는 "+Thread.currentThread().getName()+i+"이야");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}// Thread.currentThread().getName() : 현재 스레드 이름
	}
	
}
