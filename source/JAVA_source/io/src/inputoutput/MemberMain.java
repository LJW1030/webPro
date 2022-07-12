package inputoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> mem = new ArrayList<Member>();
		String ans, name, tel, birth, address;
		int year, month, day;
		Date birthday;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		while(true) {
			System.out.println("ȸ�������� �Ͻðڽ��ϱ�?(Y/N)");
			ans = sc.next();
			if(ans.contentEquals("n")) {
				break;
			}
				System.out.println("�̸� �Է�");
				name = sc.next();
				System.out.println("��ȭ��ȣ �Է�");
				tel = sc.next();
				System.out.println("�����Է�(�⵵-��-��)");
				birth = sc.next();
				StringTokenizer t = new StringTokenizer(birth, "-");
				if(t.countTokens()==3) {
					year = Integer.parseInt(t.nextToken());
					month = Integer.parseInt(t.nextToken());
					day = Integer.parseInt(t.nextToken());
					birthday = new Date(year-1900,month-1,day);
				}else {
					System.out.println("�ùٸ��� ���� �����Դϴ�. �ٽ� �������ֽʼ�");
					continue;
				}
				if(today.equals(birth.substring(birth.indexOf("-")+1))) {
					System.out.println("���� ���ϵ帳�ϴ�.");
				}
				System.out.println("�ּ� �Է�");
				sc.nextLine();
				address = sc.nextLine();
				mem.add(new Member(name, tel, birthday, address));
			}
			sc.close();
			OutputStream os = null;
			try {
				os = new FileOutputStream("txtFile/input.txt");
				for(Member m : mem) {
					System.out.print(m);
					os.write(m.toString().getBytes());
				}
				String msg = String.format("\t\t\t...���� %d�� ����\n\n", mem.size());
				System.out.println(msg);
				os.write(msg.getBytes());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os != null) {
						os.close();
					}
				} catch (Exception e2) {				}
			}
			
		}
	}
