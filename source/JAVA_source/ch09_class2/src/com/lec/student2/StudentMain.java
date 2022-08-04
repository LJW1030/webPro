package com.lec.student2;

public class StudentMain {

	public static void main(String[] args) {
		printLine('��',50);
		System.out.println("\t\t\t�� �� ǥ");
		printLine(50);
		System.out.println("��ȣ \t�̸� \t���� \t���� \t���� \t���� \t���");
		printLine(50);
		Student[] student= {new Student("���켺",90,80,95),
				            new Student("���ϴ�",100,80,95),
				            new Student("Ȳ����",95,80,90),
				            new Student("������",95,90,99),
				            new Student("������",90,90,90)};
		int[] tot = new int [5];
		double[] avg = new double [5];
		for( Student s : student) {
		s.print();
		tot[0] += s.getKor();
		tot[1] += s.getEng();
		tot[2] += s.getMath();
		tot[3] += s.getSum();
		tot[4] += s.getAvg();
		}
		for(int i=0; i<avg.length; i++) {
			avg[i] = (Math.round((double)tot[i]/tot.length));
		}
		printLine(50);
		System.out.print("����\t\t");
	for(int t : tot) {
		System.out.print(t+"\t");
	}System.out.println();
	System.out.print("���\t\t");
	for(double a : avg) {
		System.out.print((Math.round(a)+"\t"));
	}System.out.println();
		printLine('��',50);
	}
	private static void printLine(char c,int num) {
		for(int i=0; i<num; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	private static void printLine(int num) {
		for(int i=0; i<num; i++) {
			System.out.print('-');
		}
		System.out.println();
	}

}
