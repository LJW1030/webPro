package strategy2_modul;

public class Main {

	public static void main(String[] args) {

		Person st1 = new Student("2학년", "이진우", "8반");
		Person st2 = new Student("3학년", "진우리", "2반");
		Person t1 = new Teacher("20228", "김국어", "수학");
		Person t2 = new Teacher("30321", "최음악", "체육");
		Person s1 = new Staff("12-12", "박일꾼", "학생지원팀");
		Person s2 = new Staff("45-45", "이비실", "경비원");
		
		Person[] person = {st1, st2, t1, t2, s1, s2};
		System.out.println("무슨일을 할까");
		for(Person p : person) {
			p.job();
		}
		System.out.println("-----------------------------");
		System.out.println("돈 어디서 났어!?");
		for(Person per :person) {
			per.get();
		}
		System.out.println("-----------------------------");
		System.out.println("명단");
		for(Person p : person) {
			p.print();
		}
	}

}
