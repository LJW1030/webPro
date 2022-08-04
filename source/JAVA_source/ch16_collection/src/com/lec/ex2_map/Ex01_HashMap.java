package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Ex01_HashMap {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11"); // 11key값에 매핑되는 데이터 "str11" 추가
		hashMap.put(20, "str20"); // 20key값에 매핑되는 데이터 "str20" 추가
		hashMap.put(33, "str33");
		System.out.println(hashMap);
		System.out.println(hashMap.get(20)); // key값으로 데이터 get
		System.out.println("remove 전 : "+hashMap);
		hashMap.remove(20); // 20 key와 값이 remove
		System.out.println("remove 후 : "+hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 없음" : "데이터 있음");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "Lee soonsil");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator<Integer> iter = hashMap.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key+"의 데이터는"+hashMap.get(key));
		}
	}
}
