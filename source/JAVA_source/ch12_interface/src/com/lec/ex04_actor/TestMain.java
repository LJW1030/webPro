package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCantchCriminal();
		park.canSearch();
		park.saveMan();
		park.outFire();
		park.makeSpaghetti();
		park.makePizza();
		IChef chefPark = new Actor("�ڿ丮��");
	//	chefPark.saveMan(); �Ұ�
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		Ifirefighter firePark = new Actor("�ڼҹ��");
//		firePark.makePizza(); �Ұ�
		firePark.saveMan();
		firePark.outFire();
		IPoliceMan policePark = new Actor("�ڰ�����");
//		policePark.makePizza(); �Ұ�
		policePark.canCantchCriminal();
		policePark.canSearch();
	}

}
