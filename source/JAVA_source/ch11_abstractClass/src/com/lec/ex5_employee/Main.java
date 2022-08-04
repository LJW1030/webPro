package com.lec.ex5_employee;

public class Main {

	public static void main(String[] args) {
		Employee[] sawon = {new SalaryEmployee("홍길동", 24000000),
							new SalaryEmployee("강동원", 70000000),
							new SalaryEmployee("김고은", 12000000),
							new HourlyEmployee("홍길구", 100, 7000),
							new HourlyEmployee("김길자", 120, 8000)};
		for(Employee s : sawon) {
			System.out.println("-----월급명세서-----");
			s.getName();
			System.out.println("월 급 : "+s.computePay());
			int Incen = s.computeIncentive();
			if(Incen!=0) {
				System.out.println("상 여 : "+Incen);
			}
		}
	}

}
