package com.lec.parkingsystem;

public class ParkingSystemTestMain {

	public static void main(String[] args) {
		
		ParkingSystem out = new ParkingSystem("11��1111",12);
		printLine(30);
		out.outprint();//����ڿ��� out�ð� �ޱ�
		printLine(30);
		out.outprint(15);//out�ð� 15�� �ޱ�
		printLine(30);
	
	}
	private static void printLine(int c) {
		for(int i=0; i<c; i++) {
			System.out.print('-');
		}System.out.println();
	}
	
}
