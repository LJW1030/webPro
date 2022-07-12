package ex1_tryCatch;
import java.util.InputMismatchException;
// 예외: ArithmeticException, InputMismatchException
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j=1;
		do {
			try{
				System.out.print("사칙연산할 첫번째 수는 ?");
				i = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("예외1 메시지 : "+e.getMessage());
				System.out.println("반드시 정수를 입력하세요");
				sc.nextLine();
			}
		}while(true);	
		System.out.print("사칙연산할 두번째 수는 ?");
		try {
			j = sc.nextInt();
			System.out.println("i = "+i+", j = "+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j));
		}catch(InputMismatchException e) {
			System.out.println("예외2 메시지 : "+e.getMessage());
			System.out.println("두번째 수를 잘못 입력할 시 j=1");
		}catch(ArithmeticException e) {
			System.out.println("예외3 메시지 : "+e.getMessage());
		}catch(Exception e) {
			System.out.println("모든 예외는 다 이쪽으로"+e.getMessage());
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		sc.close();
	}
}
