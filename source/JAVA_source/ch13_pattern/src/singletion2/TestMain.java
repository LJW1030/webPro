package singletion2;

public class TestMain {

	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("Main�Լ����� �̱��� ��ü�� i�� : "+singobj.getI());
	}

}
