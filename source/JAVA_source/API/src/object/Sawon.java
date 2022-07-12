package object;
// Sawon s1 = new Sawon("a01", "ȫ�浿", Dept.COMPUTER) - ���� �Ի���
// Sawon s2 = new Sawon("a02", "�ű浿", Dept.PLANNING, 2022, 03, 24) - 3�� 24�� �Ի���
// System.out.println(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	public static final String COMPUTER = "COMPUTER";
	private String num; // ���
	private String name; // �̸�
	private String dept; // �μ�
	private Date   hiredate; // �Ի���
	public Sawon(String num, String name, String dept) {
		super();
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date(); // �Ի����� ���ݽð����� �ʱ�ȭ
	}
	public Sawon(String num, String name, String dept, int y, int m, int d) {
		super();
		this.num = num;
		this.name = name;
		this.dept = dept;
		//hiredate = new Date(y-1900, m-1, d); // �Ի����� y�� m�� d�Ϸ�
		hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override 
	// System.out.println(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d�� (E)");
		if(dept.length()>10) {
			return "[���]" + num + "\t[�̸�]" + name + "\t[�μ�]" + dept + "\t[�Ի���]" + sdf.format(hiredate);
		}else {
			return "[���]" + num + "\t[�̸�]" + name + "\t[�μ�]" + dept + "\t\t[�Ի���]" + sdf.format(hiredate);
		}
	}
}
