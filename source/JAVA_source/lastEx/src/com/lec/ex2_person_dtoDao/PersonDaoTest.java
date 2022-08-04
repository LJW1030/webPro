package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("����", "���", 100,90,95);
		int result = dao.insertPerson(dto); // �Է� test
		System.out.println(result == PersonDao.SUCCESS? "�Է¼���" : "�Է½���");
		System.out.println("-------------2��------------");
		ArrayList<PersonDto> dtos = dao.selectJname("���"); // ������ ��ȸ test
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�");
		}
		System.out.println("-----------3��----------");
		dtos = dao.selectAll(); // 3. ��ü��ȸ test
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}//for
		}else {
			System.out.println("��ϵ� ����� �����ϴ�");
		}
		System.out.println("-----------4��----------");
		Vector<String> jnames = dao.jnamelist(); // 4. ������ ����Ʈ test
		System.out.println(jnames);
	}
}
