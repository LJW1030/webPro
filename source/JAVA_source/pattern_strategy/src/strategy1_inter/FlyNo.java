package strategy1_inter;

public class FlyNo implements IFly {

	@Override
	public void fly() {
		System.out.println("날 수 없습니다.");
	}

}
