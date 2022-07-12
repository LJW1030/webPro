package timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // true 입력 안할시 프로그램이 끝나도 계속 timer상주(false가 디폴트값)
		TimerTask t1 = new TimerTaskEx1();
		TimerTask t2 = new TimerTaskEx2();
		timer.schedule(t1, 2000); // 2초후에 t1.run 수행
		timer.schedule(t2, 1000, 500); // 1초 후 0.5초마다 t2.run() 수행
		// 3초동안 잠깐 멈춤
		Thread.sleep(5000);
		System.out.println("끝");
	}
}
