package strategy2.modul;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//��ӹ��� ���: 3���� ��ǰ ���� /
//drive(�Ϲ�). shape(�߻�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�), setter
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh()); // engine = new EngineHigh();
		setKm(new Km10());			 // km = new Km10();
		setFuel(new FuelGasoline()); // fuel = new FuelGasoline();
	}
	@Override
	public void shape() {
		System.out.println("���׽ý� ������ door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
