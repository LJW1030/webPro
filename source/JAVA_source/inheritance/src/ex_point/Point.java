package ex_point;

public class Point {

	private int x;
	private int y;
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	} // Point p = new Point(1,2);
	  // p.pointPrint();                    - ��
	  // System.out.println(p.infoString());- ��
	  // System.out.println(p);             - ��
	public void pointprint() {
		System.out.println("2���� ��ǥ�� x��ǥ�� "+x+", y��ǥ�� "+y);
	}// - ��
	public String infoString() {
		return "2���� ��ǥ�� x��ǥ�� "+x+", y��ǥ�� "+y;
	}// - ��
	@Override
	public String toString() {
		return "2���� ��ǥ�� x��ǥ�� "+x+", y��ǥ�� "+y;
	}// - ��
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
