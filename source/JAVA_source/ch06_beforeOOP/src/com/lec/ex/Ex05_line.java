package com.lec.ex;
/*  �����������������
 *  Hello, World!
 * --------------printLine()
 *  Hello, Java!
 *  ~~~~~~~~~~~~~printLine('~')
 *  Hello, LEE!
 *  �����������������
 */
public class Ex05_line {
	public static void main(String[] args) {
		printLine('��',50);
		System.out.println("\tHello, World!");
		printLine();
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, LEE!");
		printLine('��',50);
	}
	private static void printLine(char c, int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	private static void printLine(int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print('-');
		}
		System.out.println(); //���� '-' cnt�� ����ϰ� ����
	}
	private static void printLine(char c) { // �Լ� �����ε�(���� �̸��� �Լ��� �Ű������� ����)
			for(int i=0; i<30; i++) {
				System.out.print(c);
			}
			System.out.println(); //���� '~' 20�� ����ϰ� ����
		}
	private static void printLine() { // ����Ÿ���� ���� �Ű������� ���� �޼ҵ�(�Լ�)
		for(int i=0; i<30; i++) {
			System.out.print('-');
		}
		System.out.println(); //���� '-' 20�� ����ϰ� ����
	}
}

