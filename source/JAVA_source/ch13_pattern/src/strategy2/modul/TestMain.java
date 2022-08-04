package strategy2.modul;

import strategy2.interfaces.FuelHybride;
import strategy2.interfaces.Km20;

public class TestMain {

	public static void main(String[] args) {

	 Car genesis = new Genesis();
	 Car sonata = new Sonata();
	 Car accent = new Accent();
	 Car[] cars = {genesis, sonata, accent};
//	 for(Car c : cars) {
//		 c.shape();
//		 c.drive();
//		 c.km();
//		 c.engine();
//		 c.fuel();
//	 }
	 System.out.println("소나타를 하이브리도로 교체하고 연비를 20km/l로 업그레이드 해주세요.");
	 sonata.setFuel(new FuelHybride());
	 sonata.setKm(new Km20());
	 for(int idx=0; idx<cars.length; idx++) {
		 cars[idx].shape();
		 cars[idx].drive();
		 cars[idx].km();
		 cars[idx].engine();
		 cars[idx].fuel();
	 }
	}

}
