package com.lec.student;

public class StudentTestMain {

	public static void main(String[] args) {
		Student mem = new Student("정우성",90,90,90);
		int[] tot = new int[5]; // tot[0] 국어누적, tot[1] 영어누적...tot[4] 평균누적
		double[] avg = new double[5]; // avg[0] 국어평균, avg[1] 영어평균...avg[4] 평균의평균
		
		mem.printLine('■',50);
		System.out.println("\t\t성적표");
		mem.printLine(30);
		System.out.println("\t이름  국어 영어 수학 총점 평균");
		mem.printLine(30);
		Student students[] = {new Student("\t정우성",90,90,90),
				              new Student("\t김하늘",90,90,91),
				              new Student("\t황정민",80,80,80),
				              new Student("\t강동원",80,80,81),
				              new Student("\t유아인",70,70,70)};
		for(Student s : students) {
			s.print(); //출력 후 누적
			tot[0] += s.getKor(); //국어누적
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getSum();
			tot[4] += s.getAvg(); //tot[4] = (int)(tot{4} + s.getAvg());
		}
		for(int idx=0; idx<avg.length; idx++) { //출력할 평균 계산 avg[0] = tot[0]/5
			                                    //avg[1] = tot[1]/5 ...
			avg[idx] = (double)tot[idx]/students.length;
		}
		mem.printLine(30);
		System.out.print("\t총점"+"  ");
		for (int t : tot ) {
			System.out.print(t +" ");
		}
		System.out.print("\n \t평균"+"  ");
		for (double a : avg) {
			System.out.print(a +" ");
		}
		System.out.println();
		mem.printLine('■',50);
	}

}
