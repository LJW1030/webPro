package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {

	public static void main(String[] args) {
		ArrayList<String> aL = new ArrayList<String>();
		LinkedList<String> lL = new LinkedList<String>();
		lL.add("str0"); //0번 인덱스
		lL.add("str1");
		lL.add("str2");
		lL.add("str3");
		System.out.println(lL);
		for(String list : lL) {
			System.out.println(list);
		}
		lL.clear();
		System.out.println(lL.isEmpty() ? "데이터가 없습니다." : "데이터가 있습니다.");
	}
}
