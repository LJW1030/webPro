package collection;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
	
		ArrayList<String> arrayList = new ArrayList<String>();
		// ArrayList<int> list = new ArrayList<int>(); ArrayList�� ��ü�� ArrayList�� ����
		arrayList.add("1��"); // 0�� �ε���
		arrayList.add("2��"); // 1�� �ε��� -> 2�� �ε���
		arrayList.add("3��"); // 2�� �ε��� -> 3�� �ε���
		System.out.println(arrayList);
		arrayList.add(1, "������"); // 1�� �ε���
		System.out.println(arrayList);
		arrayList.set(1, "�ٲ�ġ��"); // 1�� �ε��� ���� ����
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� - ");
		arrayList.remove(1); // 1��° �ε����� ������ ���� (2->1�� �ε���, 3->2���ε���)
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ������ ����
		for(int idx=0 ; idx<arrayList.size() ; idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t", 
					idx, arrayList.get(idx));
		}
		System.out.println();// ����
		arrayList.clear(); // arrayList�� ��� ������ ����
		if(arrayList.size() == 0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList ��ü�� ����
		//System.out.println(arrayList.size());
	}
}
