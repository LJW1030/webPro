package com.lec.ex1_string;

public class Ex2_StringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCxabc");
		String str3 = "          ja           va          ";
		System.out.println("1. "+str1.concat(str2)); //abcXabcAABCXabc
		System.out.println("2. "+str2.substring(3)); // Xabc
		System.out.println("3. "+str1.substring(3,5)); //2��°���� 5��°����
		System.out.println("4. "+str1.length()); // ���ڱ���7
		System.out.println("5. "+str1.toUpperCase()); // �빮�ڷ� ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // �ҹ��ڷ�abcxabc
		System.out.println("7. "+str1.charAt(3)); // 3��° ���� 'X'
		System.out.println("8. "+str1.indexOf('b')); // ù��° 'b'�� ������ �ε��� 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3��°���� �˻��ؼ� ù��° 'b'��ġ
		System.out.println("10. "+str1.indexOf("abc"));
		System.out.println("11. "+str1.indexOf("abc",3)); // ù��° "abc"������ ��ġ
		System.out.println("12. "+str1.indexOf("z")); // ������ -1
		System.out.println("13. "+str1.lastIndexOf('b')); // ������ 'b' ��ġ5
		System.out.println("14. "+str1.lastIndexOf('b',3)); //3��°���� �� ������ b 1
		System.out.println("15. "+str1.equals(str2)); // str1�� str2�� ���� ���ڿ����� false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // ��ҹ����� ���о��� �� true
		System.out.println("17. "+str3.trim()); // �յڰ��� ���� ja        va
		System.out.println("18. "+str1.replace('a', '9')); // 'a'�� '9'�� 9bcX9bc
		System.out.println("19. "+str1.replace("abc", "���"));// "abc"�� "���"�� ���� ���X���
		System.out.println("str�� space�� ���ֱ� : "+str3.replace(" ", ""));
		System.out.println("20. "+str1.replaceAll("abc", "Z")); // "abc"�� "Z"��
		String str = "�ȳ�Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));
		System.out.println(str.replaceAll("[��-�R]", ""));
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		System.out.println("str3 = "+str3);
	}
}
