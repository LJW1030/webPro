package com.lec.ex03_phone;
// b제품 : DMB송수신가능, LTE, TV리모콘 탑재
public class Bmodel implements IAcorporation {
	private String modelName = "B모델";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 LTX");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV리모컨 탑재");
	}

}
