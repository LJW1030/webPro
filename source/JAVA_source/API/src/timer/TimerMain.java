package timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); // true �Է� ���ҽ� ���α׷��� ������ ��� timer����(false�� ����Ʈ��)
		TimerTask t1 = new TimerTaskEx1();
		TimerTask t2 = new TimerTaskEx2();
		timer.schedule(t1, 2000); // 2���Ŀ� t1.run ����
		timer.schedule(t2, 1000, 500); // 1�� �� 0.5�ʸ��� t2.run() ����
		// 3�ʵ��� ��� ����
		Thread.sleep(5000);
		System.out.println("��");
	}
}
