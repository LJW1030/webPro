package wrapper;

public class Ex02 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("���� "+sum);
		System.out.println(i==j ? "�� int�� ����" : "�� int�� �ٸ���");
		Double iObj = 10.1;
		Double jObj = 10.1; // new Integer(10);
		sum = iObj + jObj; //sum = iObj.intValue() + jObj.intValue();
		System.out.println("���� "+sum);
		System.out.println(iObj.equals(j) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
	}
}
