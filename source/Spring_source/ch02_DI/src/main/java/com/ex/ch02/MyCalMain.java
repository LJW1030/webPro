package com.ex.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		Mycalculator myCalculator = ctx.getBean("myCal", Mycalculator.class);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		ctx.close();
	}
}
