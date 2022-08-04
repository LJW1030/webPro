package strategy1.step3;

public class TestMain {

	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		for(Robot robot : robots) {
			robot.Shape();
			robot.actionRun();
			robot.actionWalk();
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
//			if(robot instanceof SuperRobot) {
//				SuperRobot r = (SuperRobot) robot;
//				r.actionFly();
//				r.actionKnife();
//				r.actionMissile();
//			}else if(robot instanceof StandardRobot) {
//				StandardRobot r = (StandardRobot)robot;
//				r.actionFly();
//				r.actionKnife();
//				r.actionMissile();
//			}else if(robot instanceof LowRobot) {
//				LowRobot r = (LowRobot)robot;
//				r.actionFly();
//				r.actionKnife();
//				r.actionMissile();
//			}
		}
	}

}
