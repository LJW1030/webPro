package ex_override;

public class Child extends Parent{

	public Child() {
		System.out.println("�Ű������� ���� ChildŬ���� ������");
	}

	public Child(int i) {
		System.out.println("�Ű������� �ִ� ChildŬ���� ������");
	}
	public void method3() {
		System.out.println("ChildŬ������ method3");
	}
	@Override
	public void method1() {
		System.out.println("ChildŬ������ method1");
	}
	@Override
	public boolean equals(Object obj) { // objectŬ������ equals�Լ� override
		return true;
	}
	
}
