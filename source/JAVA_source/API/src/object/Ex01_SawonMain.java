package object;
// Sawon s1 = new Sawon("a01", "ȫ�浿", "COMPUTER")
// Sawon s2 = new Sawon("a02", "�ű浿", "COMPUTER")
public class Ex01_SawonMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
		Sawon s2 = new Sawon("a02", "�ű浿", Dept.HUMANRESOURCES, 2022, 03, 24);
		System.out.println(s1); // [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
		System.out.println(s2);
	}
}
