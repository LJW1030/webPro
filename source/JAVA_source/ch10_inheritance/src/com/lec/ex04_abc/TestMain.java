package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
		//A a = new A();
		S a = new A(); // ����Ÿ�Ը� S, ��ü�� A
		//B b = new B();
		S b = new B(); // ����Ÿ�Ը� S, ��ü�� B
		S c = new C(); // ����Ÿ�Ը� S, ��ü�� C
		S[] arr = {s,a,b,c};
		for(S obj : arr) {
			System.out.println(obj.s);
		}
	}
}
