package ex_point;

public class Main {

	public static void main(String[] args) {
		Point p = new Point(5,5);
		p.setX(10);
		p.pointprint();
		System.out.println(p.infoString());
		System.out.println(p);
		
		Point3D p3 = new Point3D(20,10,5);
		p3.point3Dprint();
		System.out.println(p3.info3DString());
		p3.pointprint(); // 상속을 받으면 모든 멤버와 메소드 다 상속
		System.out.println(p3.infoString()); // 상속을 받으면 모든 멤버와 메소드 다 상속
		
	}

}
