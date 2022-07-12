package strategy1_modul;

import strategy1_inter.FlyNo;
import strategy1_inter.KnifeWood;
import strategy1_inter.MissileYes;

public class StandardRobot extends Robot {

	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	

	
}
