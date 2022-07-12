package scanner;

import java.util.Scanner;

public class Ex01_nextLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt(); // '\n' 앞에 있는 숫자를 return
		System.out.println("입력하신 나이는 "+age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next(); // whitespace앞까지 값만 return
		System.out.println("입력하신 이름은 "+name);
		
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine(); // 버퍼에 남아있는 '\n'을 지우는 목적
		String address = sc.nextLine(); // '\n' 앞에 있는 값을 return하고
		System.out.println("입력하신 주소는 "+address);
		sc.close();
	}

}
