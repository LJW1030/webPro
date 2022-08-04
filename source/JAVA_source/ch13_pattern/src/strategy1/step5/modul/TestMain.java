package strategy1.step5.modul;

import strategy1.step4.inter.FlyHigh;

// 5단계 : 기능을 부품화 -> 유지보수를 간편하게

public class TestMain {

	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot robot : robots) {
//			robot.Shape();
//			robot.actionWalk();
//			robot.actionRun();
//			robot.actionFly();
//			robot.actionMissile();
//			robot.actionKnife();
//		}
		// SuperRobot 업그레이드 요청 : 날 수 있습니다. -> 높이 고공비행합니다.
		// 고공비행하는 부품 만들어 setFly만 호출
		superR.setFly(new FlyHigh());
		for(Robot robot : robots) {
			robot.Shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
	}
}
