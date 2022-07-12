package com.jinwoo.ex2;

public class Box {

	private int width;
	private int height;
	private int depth;
	private int volume;// ���� or ����
	public Box() {}
	public Box(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width*height;
	}
	public Box(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	}
	public int getvolume() {
		return volume;
	}
	public void print() {
		if(depth==0) {
			System.out.println("���̴� "+volume);
		}else {
			System.out.println("���Ǵ� "+volume);
		}
	}
}
