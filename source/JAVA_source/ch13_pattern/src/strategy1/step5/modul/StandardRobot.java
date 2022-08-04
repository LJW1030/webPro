package strategy1.step5.modul;

import strategy1.step4.inter.FlyNo;
import strategy1.step4.inter.KnifeWood;
import strategy1.step4.inter.MissileYes;


public class StandardRobot extends Robot {

	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	
}
