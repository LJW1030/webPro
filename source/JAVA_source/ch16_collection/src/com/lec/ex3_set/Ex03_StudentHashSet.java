package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {

	public static void main(String[] args) {
		HashSet<Student> st = new HashSet<Student>();
		Student s = new Student(6, "�̼���");
		st.add(s);
		st.add(s);
		System.out.println(st);
		st.add(new Student(3, "ȫ"));
		st.add(new Student(3, "ȫ"));
		st.add(new Student(6, "�̼���"));
		System.out.println(st);
	}
}
