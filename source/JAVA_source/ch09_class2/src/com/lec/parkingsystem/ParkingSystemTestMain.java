package com.lec.parkingsystem;

public class ParkingSystemTestMain {

	public static void main(String[] args) {
		
		ParkingSystem out = new ParkingSystem("11라1111",12);
		printLine(30);
		out.outprint();//사용자에게 out시간 받기
		printLine(30);
		out.outprint(15);//out시간 15로 받기
		printLine(30);
	
	}
	private static void printLine(int c) {
		for(int i=0; i<c; i++) {
			System.out.print('-');
		}System.out.println();
	}
	
}
