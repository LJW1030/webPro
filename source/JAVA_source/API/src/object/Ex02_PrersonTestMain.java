package object;

public class Ex02_PrersonTestMain {

	public static void main(String[] args) {
		Person p1 = new Person(9512121025252L);
		Person p2 = new Person(9512121025252L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		if(p1.equals(p2)) {
			System.out.println("p1�� p2�� ���� ���");
		}else {
			System.out.println("p1�� p2�� �ٸ� ���");
		}
		System.out.println(p1.equals(p3) ? "����" : "�޶�");
		if(p1==p2) {
			System.out.println("p1�� p2�� ���� �ּ�");
		}else {
			System.out.println("p1�� p2�� �ٸ� �ּ�");
		}
	}
}
