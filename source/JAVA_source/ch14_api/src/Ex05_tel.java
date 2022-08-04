import java.util.Scanner;

public class Ex05_tel {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String tel;
		while(true) {
			System.out.println("번호를 입력하시오.(X누를시 종료)");
			tel = sc.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("짝수문자열 : ");
			for(int i=0; i<tel.length(); i++) {
				if(i%2==0) {
					System.out.print(tel.charAt(i));
				}else {
					System.out.print(' ');
				}
			}
			System.out.println();
			System.out.println("문자 거꾸로");
			for(int i=tel.length()-1; i>=0; i--) {
				System.out.print(tel.charAt(i));
			}
		}
	}
}
