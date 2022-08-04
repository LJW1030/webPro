package com.lec.ex;

public class Practice {
	public static void main(String[] args) {
		int ex = sum(22);
		
		System.out.println(ex);
		System.out.println(evenOdd(ex));
	}
	
	private static int sum(int to) {
	int tot = 0;
	for(int i=0; i<=to; i++) {
		tot += i;
	}return tot;
}
	private static String evenOdd(int value) {
	return value%2==0 ? "Â¦¼öÀÔ´Ï´Ù." : "È¦¼öÀÔ´Ï´Ù.";
		
}
}

