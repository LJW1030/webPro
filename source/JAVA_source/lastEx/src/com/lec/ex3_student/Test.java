package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
	StudentDao dao = StudentDao.getInstance();
	Vector<String> mname = dao.Mnamelist();
	System.out.println(mname);
	StudentDto dto = dao.sNogetStudent(2022001);
	System.out.println(dto);
	ArrayList<StudentDto> dtos = dao.sNamegetStudent("����");
	System.out.println(dtos);
	ArrayList<StudentDto> dtos2 = dao.mNamegetStudent("��������");
	System.out.println(dtos2);
	dto = new StudentDto("�ڵ�������", "������", 93);
	System.out.println(dto);
	dto = new StudentDto("������", "��������", 100, 2022007);
	System.out.println(dto);
	ArrayList<StudentDto> dtos3 = dao.getStudent();
	for(StudentDto d : dtos3) {
		System.out.println(d);
	}
	ArrayList<StudentDto> dto4 = dao.getExpel();
	for(StudentDto e : dto4) {
		System.out.println(e);
	}
	int dto1 = dao.sNoExpel(2022006);
	System.out.println(dto1==StudentDao.SUCCESS ? "����" : "����");
	}
}
