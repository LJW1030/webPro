package string;

public class Ex02 {

	public static void main(String[] args) {
		String str = "010-9999-9999  wkdrngla789@naver.com (02)565-8888 �ݰ����ϴ�. Hello 961030-1011111,abc@naver.com";
		System.out.println(str);
		System.out.println("replace =>" + str.replace("0", "ȫ")); // 0�� ȫ���� �ٲ�
		/* ����ǥ����
		  1. ���� ����
		  \d (���ڿ� ��ġ, [0~9]�� ����) \D(���ڰ� �ȴ� ��)
		  \s (�����ڳ� ����, [a-zA-Z0-9]�� ����) \W(�����ڳ� ���ڰ� �ƴ� ����)
		  . (���� �ϳ�)
		  + (1���̻� �ݺ�)
		  * (0���̻� �ݺ�)
		  ? (0~1�� �ݺ�)
		  {2,4} (2~4ȸ �ݺ�)
		  2. ����ǥ���� ������ : http://regexpal.com  http://regexr.com
		  	ex. ��ȭ��ȣ: .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		  				�̸��� : 
		  3. Ư�� ����ǥ������ ���ڿ� ���� : replaceAll("����ǥ����", "��ü���ڿ�")
		 */
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}" , "-- ��ȭ��ȣ ���� --"));
		//��ȭ��ȣ ����
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "-- �̸��� ���� --"));
		//�̸��� ����
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//���ĺ� ��� *�� ��ü
		System.out.println(str.replaceAll("[��-�Ϥ�-��]", "*"));
		//�ѱ� ��� *�� ��ü
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
		//�ֹι�ȣ ���ڸ��� *�� ��ü
		
	}

}
