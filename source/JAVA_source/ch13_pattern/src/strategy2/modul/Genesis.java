package strategy2.modul;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//상속받은 멤버: 3가지 부품 뱐수 /
//drive(일반). shape(추상), engine(일반), km(일반), fuel(일반), setter
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh()); // engine = new EngineHigh();
		setKm(new Km10());			 // km = new Km10();
		setFuel(new FuelGasoline()); // fuel = new FuelGasoline();
	}
	@Override
	public void shape() {
		System.out.println("제네시스 외형은 door, sheet, handle로 이루어져 있습니다.");
	}

}
