package com.lec.ex1_runnable;

public class TargetExTestMain {

	public static void main(String[] args) {
		Runnable t1 = new TargetEx01();
		Runnable t2 = new TargetEx02();
		//TargetEx02 t2 = new TargetEx02();
		// "A"��� �̸��� ������ ���� - t1.run() ����
		Thread threadA = new Thread(t1, "A");
		// "B"��� �̸��� ������ ���� - t2.run() ����
		Thread threadB = new Thread(t2, "B");
		threadA.start();
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("--���� "+Thread.currentThread().getName()+i+"�̾�");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}// Thread.currentThread().getName() : ���� ������ �̸�
	}
	
}
