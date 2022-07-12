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
		System.out.println(hash.isEmpty() ? "데이터 없다" : "데이터 있다");
		hash.put(0, "이진우");
		hash.put(10, "김길길");
		hash.put(20, "박발발");
		hash.put(30, "소송송");
		Iterator<Integer> iter = hash.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key+"의 데이터는 "+hash.get(key));
		}
	}
	
}
