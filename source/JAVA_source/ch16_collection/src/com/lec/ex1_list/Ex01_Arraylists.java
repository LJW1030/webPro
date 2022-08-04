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
		ArrayList<String> arrayList = new ArrayList<String>(); // String형 ArrayList
		//ArrayList<Integer> list = new ArrayList<Integer>(); 
		// ArrayList는 객체형 ArrayList(String, Integer, Double 등)만 가능
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스
		arrayList.add("str2"); // 2번 인덱스
		System.out.println("ArrayList : "+arrayList.toString());
		arrayList.add(1, "str1111111"); // 기존 1번 인덱스->2번 인덱스, 2번 인덱스->3번 인덱스
		System.out.println("ArrayList : "+arrayList);
		arrayList.set(1, "1111"); // 1번 인덱스 값을 수정
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remonve한 후에 -");
		arrayList.remove(1); // 1번째 인덱스의 데이터 삭제 (2->1 인덱스, 3->1인덱스)
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 삭제
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d번째 인덱스 값은 %s\t", idx, arrayList.get(idx));
		}
		System.out.println();//개행
		arrayList.clear(); // arrayList의 모든 데이터 삭제
		if(arrayList.size() == 0) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList 객체를 지움
	}
}
