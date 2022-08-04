package com.lec.ex2_thread;
// Thread t1 = new Thread(target1, "A");
// Thread t1 = new ThreadEx01();
public class TargetEx01 extends Thread {
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("안녕하세요 - "+i);
			try {
				Thread.sleep(500); // 현재 작업을 0.5초동안 대기상태로
			} catch (InterruptedException e) {} 
		}
	}

}
