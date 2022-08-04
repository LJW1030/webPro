package com.lec.student;

public class StudentTestMain {

	public static void main(String[] args) {
		Student mem = new Student("���켺",90,90,90);
		int[] tot = new int[5]; // tot[0] �����, tot[1] �����...tot[4] ��մ���
		double[] avg = new double[5]; // avg[0] �������, avg[1] �������...avg[4] ��������
		
		mem.printLine('��',50);
		System.out.println("\t\t����ǥ");
		mem.printLine(30);
		System.out.println("\t�̸�  ���� ���� ���� ���� ���");
		mem.printLine(30);
		Student students[] = {new Student("\t���켺",90,90,90),
				              new Student("\t���ϴ�",90,90,91),
				              new Student("\tȲ����",80,80,80),
				              new Student("\t������",80,80,81),
				              new Student("\t������",70,70,70)};
		for(Student s : students) {
			s.print(); //��� �� ����
			tot[0] += s.getKor(); //�����
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getSum();
			tot[4] += s.getAvg(); //tot[4] = (int)(tot{4} + s.getAvg());
		}
		for(int idx=0; idx<avg.length; idx++) { //����� ��� ��� avg[0] = tot[0]/5
			                                    //avg[1] = tot[1]/5 ...
			avg[idx] = (double)tot[idx]/students.length;
		}
		mem.printLine(30);
		System.out.print("\t����"+"  ");
		for (int t : tot ) {
			System.out.print(t +" ");
		}
		System.out.print("\n \t���"+"  ");
		for (double a : avg) {
			System.out.print(a +" ");
		}
		System.out.println();
		mem.printLine('��',50);
	}

}
