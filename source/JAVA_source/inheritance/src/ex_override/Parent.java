package ex_override;

public class Parent {

	public Parent() {
		System.out.println("매개변수가 없는 Parent클래스 생성자");
	}
	public Parent(int i) {
		System.out.println("매개변수가 있는 Parent클래스 생성자");
	}
	public void method1() {
		System.out.println("Parent클래스의 method1");
	}
	public void method2() {
		System.out.println("Parent클래스의 method2");
	}

	
}
