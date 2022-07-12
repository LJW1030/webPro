package date;

import java.util.Calendar;

public class Ex01_calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // �̱��� Ŭ����
		System.out.println(cal); // ������ ����
		int year = cal.get(Calendar.YEAR); // �⵵
		int month = cal.get(Calendar.MONTH)+1; // �� 0,1,2,3,...,11��
		int day = cal.get(Calendar.DAY_OF_MONTH); // ��
		int week = cal.get(Calendar.DAY_OF_WEEK); // ��1,��2,ȭ3,��4, ... ��7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð� ����
		int ampm = cal.get(Calendar.AM_PM); // 0(����) 1(����)
		int hour = cal.get(Calendar.HOUR); // 12�ð� ����
		int min = cal.get(Calendar.MINUTE); // ��
		int sec = cal.get(Calendar.SECOND); //��
		int millisec = cal.get(Calendar.MILLISECOND); // �и�����
		
		System.out.printf("%d�� %d�� %d�� \n", year, month,day);
		switch(week) {
		case 1: System.out.print("�Ͽ���"); break;
		case 7: System.out.print("������"); break;
		case 2: System.out.print("ȭ����"); break;
		case 3: System.out.print("������"); break;
		case 4: System.out.print("�����"); break;
		case 5: System.out.print("�ݿ���"); break;
		case 6: System.out.print("�����"); break;
		}
		System.out.print(ampm == 0? "����":"����");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, min, sec, millisec);
		System.out.printf("%d�� %d�� %d�� %d\n", hour24, min, sec, millisec);
	
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %tY(��) %tm(��) %td(����) %tH(24��) %t1(12��) %tM(��) %ts(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %ts�� \n", cal, cal, cal, cal, cal, cal, cal, cal);
		//System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %t1�� %tM�� %tS��"
	}
}
