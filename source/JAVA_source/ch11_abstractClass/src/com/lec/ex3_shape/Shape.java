package com.lec.ex3_shape;
// Shape를 통해 Rect(w,h), Triangle(w,h), Circle(r)를 잘 쓰고자 함
public abstract class Shape {
	public void draw() {
		
		String className = this.getClass().getName(); // com.lec.ex3_shape.Circle
		System.out.println(className+"도형을 그려요");
	}
	public abstract double computerArea(); // 추상메소드
}
