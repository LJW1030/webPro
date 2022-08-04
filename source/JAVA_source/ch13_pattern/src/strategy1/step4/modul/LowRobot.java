package strategy1.step4.modul;

import strategy1.step4.inter.*;

public class LowRobot extends Robot {
	
	private IFly fly;
	private IMIssile missile;
	private IKnife knife;
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
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
