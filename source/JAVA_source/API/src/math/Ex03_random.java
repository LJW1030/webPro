package math;

import java.util.Random;

/* 0 <= Math.random() < 1
 * 0 <= Math.randon()*45 < 45
 */

public class Ex03_random {

	public static void main(String[] args) {
		System.out.println("0~45 미만의 double 난수 : " + Math.random()*45);
		System.out.println("0~45 미만의 정수 난수 : " + (int)(Math.random()*45));
		System.out.println("로또 번호 뽑기 : " + ( (int)(Math.random()*45)+1) );
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt());
		System.out.println("double 난수 : " + random.nextDouble()); // Math.random() 유사
		System.out.println("T/F 중 하나 난수 : " + random.nextBoolean());
		System.out.println("0~30 사이의 정수 난수 : " + random.nextInt(31)); // 0~3미만의 정수 난수
		System.out.println("로또 번호 뽑기 : " + (random.nextInt(45)+1));
	}
}
