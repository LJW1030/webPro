package com.lec.parkingsystem;

import java.util.Scanner;

import com.lec.cons.Constant;

public class ParkingSystem {
	private String number;
	private int in;
//	private final int HOURLYPARKINGRATE=2000;
	public ParkingSystem() {}
	public ParkingSystem(String number, int in) {
		this.number = number;
		this.in = in;
	System.out.println(number+"�� �������.\n"+"�����ð� : "+in+"��");
	}
//	public ParkingSystem(String number, int in, int out) {
//		super();
//		this.number = number;
//		this.in = in;
//		this.out = out;
//	}
				
	public void outprint(int out) {
		String fee = (out-in)*(Constant.HOURLYPARKINGRATE)+"��";
		System.out.println(number+"�� �ȳ��� ������.\n"+"�����ð� : "+in+"��\n"+"�����ð� : "+out+"��\n"+"������� : "+fee);
	}
	public void outprint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �ð��� �Է��ϼ��� : ");
		int out=sc.nextInt();
		String fee = (out-in)*(Constant.HOURLYPARKINGRATE)+"��";
		System.out.println(number+"�� �ȳ��� ������.\n"+"�����ð� : "+in+"��\n"+"�����ð� : "+out+"��\n"+"������� : "+fee);
		sc.close();
	}

}
