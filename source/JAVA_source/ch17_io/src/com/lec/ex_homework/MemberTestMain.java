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
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?(Y/N)");
			ans = sc.next();
			if (ans.equalsIgnoreCase("n")) {
				break;
			} else if (ans.equalsIgnoreCase("y")) {
				System.out.println("�̸� �Է�");
				name = sc.next();
				System.out.println("��ȭ��ȣ �Է�");
				tel = sc.next();
				System.out.println("����(yyyy-MM-dd) �Է�");
				birth = sc.next(); 
				StringTokenizer t = new StringTokenizer(birth,"-");
				if(t.countTokens()==3) {
					year = Integer.parseInt(t.nextToken());
					month = Integer.parseInt(t.nextToken());
					day = Integer.parseInt(t.nextToken());
					birthday = new Date(year-1990, month-1, day);
				}else {
				System.out.println("���� ������ �ùٸ��� �ʽ��ϴ�.");
				continue;
				}
				if(today.equals(birth.substring(birth.lastIndexOf('-')+1))) {
					System.out.println(name+"�� �����̽ñ���. ���ϵ帳�ϴ�");
				}
				System.out.println("�ּ� �Է�");
				sc.nextLine();
				address = sc.nextLine();
				mem.add(new Member(name, tel, birthday, address));
				}
		}// while
			OutputStream os = null;
			try {
				os = new FileOutputStream("D:\\webPro\\source\\01_java\\ch17_io\\src\\com\\lec\\ex_homework\\member.txt");
				if (mem.isEmpty()) {
					System.out.println("ȸ����� ������ �����ϴ�.");
				} else {
					System.out.print("ȸ�� ����Ʈ\n");
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
