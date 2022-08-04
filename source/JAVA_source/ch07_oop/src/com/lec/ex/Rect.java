package com.lec.ex;
// 데이터(private), 메소드(public), setter&getter(private한 데이터를 사용하기위해)
// 데이터: width/Height, 메소드:area()
// Rect r1 = new Rect()
public class Rect {
	private int width;
	private int height;
	
	public int area() {
		return width*height;
	}
	//setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	//getter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return width;
	}
	
}
