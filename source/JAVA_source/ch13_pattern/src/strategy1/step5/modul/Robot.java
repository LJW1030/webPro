package strategy1.step5.modul;

import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMIssile;
// Robot r = new Robot();
// r.actionFly; ����(�����ڿ��� fly=new FlyNo(); ���ؼ�) �̸� �����ϰ��� ��ü�����Ұ��ϵ��� abstract class
public abstract class Robot {
	private IFly fly;
	private IMIssile missile;
	private IKnife knife;
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�");
	}
	public void Shape() {
		String className = getClass().getName(); // strategy1.step2.SuperRobot
		int idx = className.lastIndexOf('.'); // �� ������ '.'�� �ִ� ��ġ
		String name = className.substring(idx+1); // idx+1��° �۾����� ������
		System.out.println(name + " �Դϴ�.������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile(){
		missile.missile();
	}
	public void actionKnife(){
		knife.knife();
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMIssile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}
