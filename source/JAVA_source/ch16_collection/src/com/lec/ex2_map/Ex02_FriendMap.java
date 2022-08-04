package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendMap {

	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("홍길동", "010-9999-9999"));
		friends.put("010-8888-8888", new Friend("김길길", "010-8888-8888"));
		friends.put("010-7777-7777", new Friend("박발발", "010-7777-7777", new Date(98,04,25)));
		friends.put("010-6666-6666", new Friend("소솔솔", "010-6666-6666"));
		friends.put("010-5555-5555", new Friend("강갈갈", "010-5555-5555", new Date(95,12,12)));
		Iterator<String> iter = friends.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+"의 데이터는 "+friends.get(key));
		}
	}
}
