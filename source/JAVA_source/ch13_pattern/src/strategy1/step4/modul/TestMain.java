package strategy1.step4.modul;
//4다녜 : 기능을 부품화

public class TestMain {

	public static void main(String[] args) {
		SuperRobot superR = new SuperRobot();
		StandardRobot standardR = new StandardRobot();
		LowRobot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
		for(Robot robot : robots) {
			robot.Shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		// lowR.setFly(new FlyYes()); 5단계에서 해결
	}
}
