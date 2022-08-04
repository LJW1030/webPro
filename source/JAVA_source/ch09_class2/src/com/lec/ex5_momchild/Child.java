package com.lec.ex5_momchild;
// Child first = new Child("Ã¹Â°");
// first.takeMoney(1000); ¾ö¸¶ ­¿ø¸¸
public class Child {
	private String name;
	static MomPouch momPouch;//static º¯¼ö´Â Á¤º¸¸¦ °øÀ¯ÇØ¾ßÇÒ ¶§ »ç¿ë
	public Child() {}
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;//momPouch.money = momPouch.money - money;
			System.out.println(name+"°¡ "+money+"¿ø °¡Á®°¡¼­ ¾ö¸¶ Áö°©¿¡ "+momPouch.money+"¿ø ÀÖÀ½");
		}else {
			System.out.println(name+"°¡ µ·À» ¸ø¹ŞÀ½, ÇöÀç ¾ö¸¶ Áö°©¿¡´Â"+momPouch.money+"¿ø ÀÖÀ½");
		}//if
	}//takmMoney
}//main
