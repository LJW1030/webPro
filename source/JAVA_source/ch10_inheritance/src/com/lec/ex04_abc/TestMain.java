package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
		//A a = new A();
		S a = new A(); // 변수타입만 S, 객체는 A
		//B b = new B();
		S b = new B(); // 변수타입만 S, 객체는 B
		S c = new C(); // 변수타입만 S, 객체는 C
		S[] arr = {s,a,b,c};
		for(S obj : arr) {
			System.out.println(obj.s);
		}
	}
}
