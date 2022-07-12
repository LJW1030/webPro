package ex_override;

public class TestMain {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		if(p1 == p2) {
			System.out.println("�� ��ü�� ����.");
		}else {
			System.out.println("�� ��ü�� �ٸ���.");
		}
		Child c1 = new Child();
		if(c1.equals(p2)) {
			System.out.println("����.");
		}
		p1.method1();
		p2.method2();
		System.out.println("---------------------");
		c1.method1();
		c1.method2();
		c1.method3();
		System.out.println("---------------------");
		Parent c2 = new Child(2);
		c2.method1();
		c2.method2();
//		c2.method3(); �Ұ�-������ type�� Child�� �ƴ� Parent�̱� ����.
		if(c2 instanceof Child) {
			((Child)c2).method3(); // Child�� �� ��ȯ
		}else {
			System.out.println("�� ��ȯ �Ұ�");
		}
	}
}
