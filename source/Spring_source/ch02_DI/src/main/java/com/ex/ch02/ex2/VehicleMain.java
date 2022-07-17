package com.ex.ch02.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleMain {
	public static void main(String[] args) {
		String location = "classpath:applicaitonCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		vh.ride("이진우");
		ctx.close();
	}
}
