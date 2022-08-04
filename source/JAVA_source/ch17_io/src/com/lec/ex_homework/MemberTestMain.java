package com.lec.ex_homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> mem = new ArrayList<Member>();
		String ans, name, tel, birth, address;
		int year, month, day;
		Date birthday;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		while (true) {
			System.out.println("회원가입 하시겠습니까?(Y/N)");
			ans = sc.next();
			if (ans.equalsIgnoreCase("n")) {
				break;
			} else if (ans.equalsIgnoreCase("y")) {
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("전화번호 입력");
				tel = sc.next();
				System.out.println("생일(yyyy-MM-dd) 입력");
				birth = sc.next(); 
				StringTokenizer t = new StringTokenizer(birth,"-");
				if(t.countTokens()==3) {
					year = Integer.parseInt(t.nextToken());
					month = Integer.parseInt(t.nextToken());
					day = Integer.parseInt(t.nextToken());
					birthday = new Date(year-1990, month-1, day);
				}else {
				System.out.println("생일 정보가 올바르지 않습니다.");
				continue;
				}
				if(today.equals(birth.substring(birth.lastIndexOf('-')+1))) {
					System.out.println(name+"님 생일이시군요. 축하드립니다");
				}
				System.out.println("주소 입력");
				sc.nextLine();
				address = sc.nextLine();
				mem.add(new Member(name, tel, birthday, address));
				}
		}// while
			OutputStream os = null;
			try {
				os = new FileOutputStream("D:\\webPro\\source\\01_java\\ch17_io\\src\\com\\lec\\ex_homework\\member.txt");
				if (mem.isEmpty()) {
					System.out.println("회원등록 정보가 없습니다.");
				} else {
					System.out.print("회원 리스트\n");
					for (Member m : mem) {
						System.out.println(m);
						os.write(m.toString().getBytes());
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		
	}
}
