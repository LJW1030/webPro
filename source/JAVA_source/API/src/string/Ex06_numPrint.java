package string;

import java.util.Scanner;

// 전화번호 입력받아 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
public class Ex06_numPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("전화번호를 입력하시오. (끝내기 : p)");
			String num = sc.next();
			if(num.equalsIgnoreCase("p")) break;
			System.out.println("짝수번째 문자 : ");
			for(int i=0; i<num.length(); i++) {
				if(i%2 ==0) {
				System.out.print(num.charAt(i));
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.print("번호를 거꾸로: ");
			for(int i=num.length()-1; i>=0; i--) {
				System.out.print(num.charAt(i));
			}
			System.out.println();
			int str1 = num.indexOf('-');
			int str2 = num.lastIndexOf('-');
			String pre = num.substring(0, str1);
			String mid = num.substring(str1+1,str2);
			String last = num.substring(str2+1);
			System.out.println("전화번호 앞자리: "+pre);
			System.out.println("전화번호 중간자리: "+mid);
			System.out.println("전화번호 뒷자리: "+last);
			
		}
		sc.close();
	}

}
