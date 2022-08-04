package strategy1.step5.modul;

import strategy1.step4.inter.FlyHigh;

// 5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ�

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
		// SuperRobot ���׷��̵� ��û : �� �� �ֽ��ϴ�. -> ���� ��������մϴ�.
		// ��������ϴ� ��ǰ ����� setFly�� ȣ��
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
