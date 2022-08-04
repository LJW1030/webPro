package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendMap {

	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("ȫ�浿", "010-9999-9999"));
		friends.put("010-8888-8888", new Friend("����", "010-8888-8888"));
		friends.put("010-7777-7777", new Friend("�ڹ߹�", "010-7777-7777", new Date(98,04,25)));
		friends.put("010-6666-6666", new Friend("�Ҽּ�", "010-6666-6666"));
		friends.put("010-5555-5555", new Friend("������", "010-5555-5555", new Date(95,12,12)));
		Iterator<String> iter = friends.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+"�� �����ʹ� "+friends.get(key));
		}
	}
}
