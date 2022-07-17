package com.ex.ch02.ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		ExamConsole con = ctx.getBean("examConsole", ExamConsole.class);
		con.print();
		ctx.close();
	}
}
