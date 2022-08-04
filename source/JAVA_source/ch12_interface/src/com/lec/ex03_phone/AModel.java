package com.lec.ex03_phone;
// a제품 : DMB송수신가능, 5G, TV리모콘 탑재,
public class Amodel implements IAcorporation {
	private String modelName;
	public Amodel () {
		modelName = "A모델";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 5G");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 Tv리모컨 탑재");
	}

}
