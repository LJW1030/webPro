package ex_point;

public class Point {

	private int x;
	private int y;
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	} // Point p = new Point(1,2);
	  // p.pointPrint();                    - ¨ç
	  // System.out.println(p.infoString());- ¨è
	  // System.out.println(p);             - ¨é
	public void pointprint() {
		System.out.println("2Â÷¿ø ÁÂÇ¥ÀÇ xÁÂÇ¥°¡ "+x+", yÁÂÇ¥°¡ "+y);
	}// - ¨ç
	public String infoString() {
		return "2Â÷¿ø ÁÂÇ¥ÀÇ xÁÂÇ¥°¡ "+x+", yÁÂÇ¥°¡ "+y;
	}// - ¨è
	@Override
	public String toString() {
		return "2Â÷¿ø ÁÂÇ¥ÀÇ xÁÂÇ¥°¡ "+x+", yÁÂÇ¥°¡ "+y;
	}// - ¨é
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
