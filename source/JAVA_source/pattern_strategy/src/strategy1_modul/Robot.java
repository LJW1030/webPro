package strategy1_modul;

import strategy1_inter.*;

public class Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.'); // className�� ������ '.' ��ġ
		String name = className.substring(idx+1); // idx+1�ڸ����� ������
		System.out.println(name+"�� �Ӹ�+����+��+�ٸ��� �����Ǿ� �ֽ��ϴ�.");
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
