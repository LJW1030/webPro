package math;

import java.util.Random;

/* 0 <= Math.random() < 1
 * 0 <= Math.randon()*45 < 45
 */

public class Ex03_random {

	public static void main(String[] args) {
		System.out.println("0~45 �̸��� double ���� : " + Math.random()*45);
		System.out.println("0~45 �̸��� ���� ���� : " + (int)(Math.random()*45));
		System.out.println("�ζ� ��ȣ �̱� : " + ( (int)(Math.random()*45)+1) );
		Random random = new Random();
		System.out.println("int ���� : " + random.nextInt());
		System.out.println("double ���� : " + random.nextDouble()); // Math.random() ����
		System.out.println("T/F �� �ϳ� ���� : " + random.nextBoolean());
		System.out.println("0~30 ������ ���� ���� : " + random.nextInt(31)); // 0~3�̸��� ���� ����
		System.out.println("�ζ� ��ȣ �̱� : " + (random.nextInt(45)+1));
	}
}
