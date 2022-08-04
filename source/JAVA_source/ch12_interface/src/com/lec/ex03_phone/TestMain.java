package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		
		Amodel a = new Amodel();
		Bmodel b = new Bmodel();
		Cmodel c = new Cmodel();
//		a.dmbReceive();
//		a.lte();
//		a.tvRemoteControl();
		IAcorporation[] phone = {a, b, c};
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName()); // Å¬·¡½º com.lec.ex03_phone.Amodel
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
		}
	}

}
