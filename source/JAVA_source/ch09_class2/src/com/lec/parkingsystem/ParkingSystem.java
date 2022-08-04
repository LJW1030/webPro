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
	System.out.println(number+"님 어서오세요.\n"+"입차시간 : "+in+"시");
	}
//	public ParkingSystem(String number, int in, int out) {
//		super();
//		this.number = number;
//		this.in = in;
//		this.out = out;
//	}
				
	public void outprint(int out) {
		String fee = (out-in)*(Constant.HOURLYPARKINGRATE)+"원";
		System.out.println(number+"님 안녕히 가세요.\n"+"입차시간 : "+in+"시\n"+"출차시간 : "+out+"시\n"+"주차요금 : "+fee);
	}
	public void outprint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("나가는 시간을 입력하세요 : ");
		int out=sc.nextInt();
		String fee = (out-in)*(Constant.HOURLYPARKINGRATE)+"원";
		System.out.println(number+"님 안녕히 가세요.\n"+"입차시간 : "+in+"시\n"+"출차시간 : "+out+"시\n"+"주차요금 : "+fee);
		sc.close();
	}

}
