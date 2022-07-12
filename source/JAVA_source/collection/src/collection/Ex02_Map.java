package collection;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02_Map {

	public static void main(String[] args) {
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		hash.put(10, "str10");
		hash.put(15, "str15");
		hash.put(20, "str20");
		System.out.println(hash.get(15));
		System.out.println(hash);
		hash.remove(15);
		System.out.println(hash);
		hash.clear();
		System.out.println(hash.isEmpty() ? "������ ����" : "������ �ִ�");
		hash.put(0, "������");
		hash.put(10, "����");
		hash.put(20, "�ڹ߹�");
		hash.put(30, "�Ҽۼ�");
		Iterator<Integer> iter = hash.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key+"�� �����ʹ� "+hash.get(key));
		}
	}
	
}
