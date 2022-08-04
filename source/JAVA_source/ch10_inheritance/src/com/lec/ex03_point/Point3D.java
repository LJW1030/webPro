package com.lec.ex03_point;
// Point3D p1 = new Point3D(20,10,5)
// p1.pointPrint();
public class Point3D extends Point {
	private int z;

	public Point3D() {}

	public Point3D(int x, int y, int z) {
		setX(x); setY(y);
		this.z = z;
	}// p1.point3DPring() sysout(p1.info3DString()) sysout(p1)
	public void point3DPrint() {
		System.out.println("2Â÷¿ø ÁÂÇ¥: x="+getX()+", y="+getY()+", z="+z);
	}
	public String info3DString() {
		return "3Â÷¿ø ÁÂÇ¥: x="+getX()+", y="+getY()+", z="+z;
	}
	public String toString() {
		return "3Â÷¿ø ÁÂÇ¥: x="+getX()+", y="+getY()+", z="+z;
	}
}
