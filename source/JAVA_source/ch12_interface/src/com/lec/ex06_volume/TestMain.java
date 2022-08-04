package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume[] volumes= {new TV(1), new Spearker(5), new TV(10), new Spearker(7)};
		for(IVolume v : volumes) {
			v.volumeUp(10);
			v.volumeUp(45);
			v.volumeDown();
			v.volumeDown(20);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

}
