package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCantchCriminal();
		park.canSearch();
		park.saveMan();
		park.outFire();
		park.makeSpaghetti();
		park.makePizza();
		IChef chefPark = new Actor("박요리사");
	//	chefPark.saveMan(); 불가
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		Ifirefighter firePark = new Actor("박소방관");
//		firePark.makePizza(); 불가
		firePark.saveMan();
		firePark.outFire();
		IPoliceMan policePark = new Actor("박경찰관");
//		policePark.makePizza(); 불가
		policePark.canCantchCriminal();
		policePark.canSearch();
	}

}
