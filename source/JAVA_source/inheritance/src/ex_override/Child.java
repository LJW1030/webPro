package ex_override;

public class Child extends Parent{

	public Child() {
		System.out.println("매개변수가 없는 Child클래스 생성자");
	}

	public Child(int i) {
		System.out.println("매개변수가 있는 Child클래스 생성자");
	}
	public void method3() {
		System.out.println("Child클래스의 method3");
	}
	@Override
	public void method1() {
		System.out.println("Child클래스의 method1");
	}
	@Override
	public boolean equals(Object obj) { // object클래스의 equals함수 override
		return true;
	}
	
}
