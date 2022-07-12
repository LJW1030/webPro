package object;

public class Ex04_RectangleTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Rectangle r1 = new Rectangle();
		r1.setHeight(10);
		r1.setWidth(5);
		//Rectangle r2 = r1; 복제가 아닌 같은 주소를 가리킴
		Rectangle r2 = (Rectangle) r1.clone(); // 복제 
		System.out.println("r1 : "+r1);
		System.out.println("r2 : "+r2);
		System.out.println(r1.equals(r2) ? "같은 사각형" : "다른 사각형");
		System.out.println(r1==r2 ? "복사한게 아닌 같은 주소를 가리킴" : "다른 주소를 가리킴");
		if(r1 != r2 && r1.equals(r2)) {
			System.out.println("복제 성공");
		}else {
			System.out.println("복제 실패");
		}
		System.out.println(r1.getClass().getName());
	}
}
