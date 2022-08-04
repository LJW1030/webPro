package com.lec.Quiz;
// 1~10 숫자 중 짝수나 홀수의 누적값
public class Quiz2_for {

	public static void main(String[] args) {
		int tot = 0;
		for( int i=1; i<=10; i++) 
			if ( i%2==0) {
			tot += i;  
			}
			System.out.println("짝수의 합은 "+tot);
		
		

			
		
		
	
}
}