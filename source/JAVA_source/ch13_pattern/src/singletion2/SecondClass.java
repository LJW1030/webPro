package singletion2;

public class SecondClass {

	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("seconClass ������ ������");
		System.out.println("�̱��� ����ü�� i��: "+singletonObject.getI());
		System.out.println("SecondClass ������ ��");
	}
}
