package com.lec.personinfo;

public class PersoninfoTestMain {

	public static void main(String[] args) {
		
//		Personinfo info = new Personinfo("ȫ�浿",20,'m');
//		Personinfo info2 = new Personinfo("��浿",24,'f');
		Personinfo[] person = {new Personinfo("ȫ�浿",20,'m'),
				               new Personinfo("��浿",24,'f')};
		
		
		for(int idx=0; idx<person.length; idx++) {
			person[idx].print();
		}
	}

}
