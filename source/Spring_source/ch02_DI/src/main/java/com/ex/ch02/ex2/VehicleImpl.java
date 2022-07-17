package com.ex.ch02.ex2;

import lombok.Data;

@Data
public class VehicleImpl implements Vehicle {
	private String vehicle;
	private int speed;
	public void ride(String name) {
		System.out.println(name+"은 "+vehicle+"을 "+speed+"km/h로 타고간다");
	}

}
