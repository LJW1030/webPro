package string;

public class Ex01 {

	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java"); // ������ ��ü ����
		if(str1 == str2) {
			System.out.println("�� ������ ���� �ּҰ�");
		}else {
			System.out.println("�� ������ �ٸ� �ּҰ�");
		}
		if(str1.equals(str2) ) {
			System.out.println("���� ���ڿ�");
		}
		System.out.println(str1 == str3 ? "�� ������ ���� �ּҰ�" : "�� ������ �ٸ� �ּҰ�");
		System.out.println(str1.equals(str3)? "���� ���ڿ�" : "�ٸ� ���ڿ�");
	}
}
