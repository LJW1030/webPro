package strategy2_modul;

public class Main {

	public static void main(String[] args) {

		Person st1 = new Student("2�г�", "������", "8��");
		Person st2 = new Student("3�г�", "���츮", "2��");
		Person t1 = new Teacher("20228", "�豹��", "����");
		Person t2 = new Teacher("30321", "������", "ü��");
		Person s1 = new Staff("12-12", "���ϲ�", "�л�������");
		Person s2 = new Staff("45-45", "�̺��", "����");
		
		Person[] person = {st1, st2, t1, t2, s1, s2};
		System.out.println("�������� �ұ�");
		for(Person p : person) {
			p.job();
		}
		System.out.println("-----------------------------");
		System.out.println("�� ��� ����!?");
		for(Person per :person) {
			per.get();
		}
		System.out.println("-----------------------------");
		System.out.println("���");
		for(Person p : person) {
			p.print();
		}
	}

}
