package strategy1_modul;

import strategy1_inter.*;

public class Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.'); // className의 마지막 '.' 위치
		String name = className.substring(idx+1); // idx+1자리부터 끝까지
		System.out.println(name+"은 머리+몸통+팔+다리로 구성되어 있습니다.");
	}
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	
}
