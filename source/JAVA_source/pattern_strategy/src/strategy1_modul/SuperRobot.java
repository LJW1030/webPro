package strategy1_modul;

import strategy1_inter.FlyYes;
import strategy1_inter.KnifeLazer;
import strategy1_inter.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
	

	
}
