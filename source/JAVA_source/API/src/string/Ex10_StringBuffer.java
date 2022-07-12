package string;

public class Ex10_StringBuffer {

	public static void main(String[] args) {
		
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def"); // ������ "abc"�� "def"�� �߰�
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.insert(3, "AAA"); // 3��°�� "AAA" �߰�
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 6); // 3��°���� 6��° �ձ��� ���� :abcAdef
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.deleteCharAt(3); // 3��° ���ڸ� ����  = delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
	}

}
