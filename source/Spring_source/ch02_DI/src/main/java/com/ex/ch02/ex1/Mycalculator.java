package com.ex.ch02.ex1;

public class Mycalculator {
	private Calculator calculator;
	private int num1;
	private int num2;
	public void add() {
		calculator.addition(num1, num2);
	}
	public void sub() {
		calculator.subtraction(num1, num2);
	}
	public void mul() {
		calculator.multiplication(num1, num2);
	}
	public void div() {
		calculator.division(num1, num2);
	}
}
