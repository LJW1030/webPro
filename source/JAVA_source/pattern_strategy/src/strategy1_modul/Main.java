package strategy1_modul;

import strategy1_inter.MissileNuclear;

public class Main {

	public static void main(String[] args) {
		
		Robot superR = new SuperRobot();
		Robot standardR	= new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot r : robots ) {	
//			r.shape();
//			r.actionFly();
//			r.actionKnife();
//			r.actionMissile();
//		}
		superR.setMissile(new MissileNuclear());
		for(Robot r : robots ) {	
			r.shape();
			r.actionFly();
			r.actionKnife();
			r.actionMissile();
		}
	}
}

