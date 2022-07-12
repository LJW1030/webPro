package ex1_tryCatch;
//예외처리 추가
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사칙연산할 첫번째 수는 ?");
		int i = sc.nextInt();
		System.out.print("사칙연산할 두번째 수는 ?");
		int j = sc.nextInt();
		System.out.println("i = "+i+", j = "+j);
		System.out.println("i * j = "+(i*j));
		try {
			System.out.println("i / j = "+(i/j)); // 예외 발생 가능 부분
		}catch(Exception e) {
			// 예외가 발생할 경우 우회적으로 수행할 로직
			System.out.println("예외메시지 : "+e.getMessage()); // 예외메시지만 출력
			//e.printStackTrace(); // 예외사항을 자세히 출력
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
