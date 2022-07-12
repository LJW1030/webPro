package object;

public class point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		point3D p = new point3D();
		point3D p1 = new point3D(5.1, 2, 3.3);
		System.out.println(p);
		System.out.println(p1);
		point3D p2 = (point3D) p1.clone();
		System.out.println(p2);
	}

}
