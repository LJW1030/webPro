package object;

public class point3D implements Cloneable{

	private double x;
	private double y;
	private double z;
	public point3D() {
//		x=0.0;
//		y=0.0;
//		z=0.0;
	}
	public point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "x����" + x + "\ty����" + y + "\tz����" + z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof point3D) {
			point3D o = (point3D)obj;
			boolean xC = x == o.x;
			boolean yC = y == o.y;
			boolean zC = z == o.z;
			return xC && yC && zC;
		}
		return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
