package com.lec.loop;
// 10. 9. 8. 7. 6. ~ 2. 1.
public class Ex06_while {
	public static void main(String[] args) {
		int i = 10;
		while(i>=1) {
			System.out.println(i+". ");
			--i;
		}
//		for(int i=10; i>=1 ; i--) {
//			System.out.println(i+". ");
//		}
	}
}
