package com.lec.ex5_employee;

public class Main {

	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("ȫ�浿", 24000000),
							new SalaryEmployee("������", 70000000),
							new SalaryEmployee("�����", 12000000),
							new HourlyEmployee("ȫ�汸", 100, 7000),
							new HourlyEmployee("�����", 120, 8000)};
		for(Employee s : sawon) {
			System.out.println("-----���޸���-----");
			s.getName();
			System.out.println("�� �� : "+s.computePay());
			int Incen = s.computeIncentive();
			if(Incen!=0) {
				System.out.println("�� �� : "+Incen);
			}
		}
	}

}
