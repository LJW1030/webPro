package com.lec.method;
// Arithmetic.sum/evenOdd(static) vs abs(일반-stack 메모리로 가져와야함)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		System.out.println("1~10까지의 합은 "+tot);
		System.out.println(Arithmetic.evenOdd(tot));
		Arithmetic ar = new Arithmetic();//instance (stack메모리로 가져옴)
		System.out.println(ar.abs(-8));
	}
}
