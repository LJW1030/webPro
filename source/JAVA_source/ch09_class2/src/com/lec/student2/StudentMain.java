package com.lec.student2;

public class StudentMain {

	public static void main(String[] args) {
		printLine('■',50);
		System.out.println("\t\t\t성 적 표");
		printLine(50);
		System.out.println("번호 \t이름 \t국어 \t영어 \t수학 \t총점 \t평균");
		printLine(50);
		Student[] student= {new Student("정우성",90,80,95),
				            new Student("김하늘",100,80,95),
				            new Student("황정민",95,80,90),
				            new Student("강동원",95,90,99),
				            new Student("유아인",90,90,90)};
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
		System.out.print("총점\t\t");
	for(int t : tot) {
		System.out.print(t+"\t");
	}System.out.println();
	System.out.print("평균\t\t");
	for(double a : avg) {
		System.out.print((Math.round(a)+"\t"));
	}System.out.println();
		printLine('■',50);
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
