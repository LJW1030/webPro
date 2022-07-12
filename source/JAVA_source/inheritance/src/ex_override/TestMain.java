package ex_override;

public class TestMain {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		if(p1 == p2) {
			System.out.println("두 객체는 같다.");
		}else {
			System.out.println("두 객체는 다르다.");
		}
		Child c1 = new Child();
		if(c1.equals(p2)) {
			System.out.println("같다.");
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
//		c2.method3(); 불가-변수의 type이 Child가 아닌 Parent이기 때문.
		if(c2 instanceof Child) {
			((Child)c2).method3(); // Child로 형 변환
		}else {
			System.out.println("형 변환 불가");
		}
	}
}
