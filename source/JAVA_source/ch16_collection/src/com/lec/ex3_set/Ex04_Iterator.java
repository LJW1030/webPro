package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("STR"); arr.add("STR");
		System.out.println(arr);
		Iterator<String> iter = arr.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		for(String l : arr) {
			System.out.println(l);
		}
		//		��
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ȫ", "010-9999-9999");
		map.put("��", "010-1111-1111");
		Iterator<String> iter1 = map.keySet().iterator();
		while(iter1.hasNext()) {
			String key = iter1.next();
			System.out.println(key+"Ű�� ������ : "+map.get(key));
		}
		// 		��
		HashSet<String> set = new HashSet<String>();
		set.add("str0"); set.add("str1"); set.add("str1");
		Iterator<String> iter2 = set.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
	}
}
