package ex1_tryCatch;
// 예외처리 없음
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사칙연산할 첫번째 수는 ?");
		int i = sc.nextInt();
		System.out.print("사칙연산할 두번째 수는 ?");
		int j = sc.nextInt();
		System.out.println("i = "+i+", j = "+j);
		System.out.println("i * j = "+(i*j));
		System.out.println("i / j = "+(i/j)); // 예외 발생 가능 부분
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
