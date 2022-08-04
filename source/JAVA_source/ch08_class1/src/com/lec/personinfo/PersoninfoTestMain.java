package com.lec.personinfo;

public class PersoninfoTestMain {

	public static void main(String[] args) {
		
//		Personinfo info = new Personinfo("È«±æµ¿",20,'m');
//		Personinfo info2 = new Personinfo("±è±æµ¿",24,'f');
		Personinfo[] person = {new Personinfo("È«±æµ¿",20,'m'),
				               new Personinfo("±è±æµ¿",24,'f')};
		
		
		for(int idx=0; idx<person.length; idx++) {
			person[idx].print();
		}
	}

}
