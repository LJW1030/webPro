package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_Arraylists {

	public static void main(String[] args) {
		String[] array = new String[5];
		array[0] = "str0"; array[1] = "str1"; array[3] = "str3";
		for(int i=0; i<array.length; i++) {
			System.out.printf("array[%d] = %s\t", i, array[i]);
		}
		System.out.println();
		for(String a : array) {
			System.out.print(a + "\t");
		}
		System.out.println("\n-----------Arraylist------------");
		ArrayList<String> arrayList = new ArrayList<String>(); // String�� ArrayList
		//ArrayList<Integer> list = new ArrayList<Integer>(); 
		// ArrayList�� ��ü�� ArrayList(String, Integer, Double ��)�� ����
		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 1�� �ε���
		arrayList.add("str2"); // 2�� �ε���
		System.out.println("ArrayList : "+arrayList.toString());
		arrayList.add(1, "str1111111"); // ���� 1�� �ε���->2�� �ε���, 2�� �ε���->3�� �ε���
		System.out.println("ArrayList : "+arrayList);
		arrayList.set(1, "1111"); // 1�� �ε��� ���� ����
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remonve�� �Ŀ� -");
		arrayList.remove(1); // 1��° �ε����� ������ ���� (2->1 �ε���, 3->1�ε���)
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ����
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t", idx, arrayList.get(idx));
		}
		System.out.println();//����
		arrayList.clear(); // arrayList�� ��� ������ ����
		if(arrayList.size() == 0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList ��ü�� ����
	}
}
