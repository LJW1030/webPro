package strategy1_modul;

import strategy1_inter.FlyNo;
import strategy1_inter.KnifeNo;
import strategy1_inter.MissileNo;

public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	

	
}
