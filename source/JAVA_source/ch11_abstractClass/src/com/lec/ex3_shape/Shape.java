package com.lec.ex3_shape;
// Shape�� ���� Rect(w,h), Triangle(w,h), Circle(r)�� �� ������ ��
public abstract class Shape {
	public void draw() {
		
		String className = this.getClass().getName(); // com.lec.ex3_shape.Circle
		System.out.println(className+"������ �׷���");
	}
	public abstract double computerArea(); // �߻�޼ҵ�
}
