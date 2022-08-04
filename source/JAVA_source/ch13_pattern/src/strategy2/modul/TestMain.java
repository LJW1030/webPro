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
	 System.out.println("�ҳ�Ÿ�� ���̺긮���� ��ü�ϰ� ���� 20km/l�� ���׷��̵� ���ּ���.");
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
