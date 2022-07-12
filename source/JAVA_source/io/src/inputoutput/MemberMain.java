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
			System.out.println("회원가입을 하시겠습니까?(Y/N)");
			ans = sc.next();
			if(ans.contentEquals("n")) {
				break;
			}
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("전화번호 입력");
				tel = sc.next();
				System.out.println("생일입력(년도-월-일)");
				birth = sc.next();
				StringTokenizer t = new StringTokenizer(birth, "-");
				if(t.countTokens()==3) {
					year = Integer.parseInt(t.nextToken());
					month = Integer.parseInt(t.nextToken());
					day = Integer.parseInt(t.nextToken());
					birthday = new Date(year-1900,month-1,day);
				}else {
					System.out.println("올바르지 않은 생일입니다. 다시 가입해주십쇼");
					continue;
				}
				if(today.equals(birth.substring(birth.indexOf("-")+1))) {
					System.out.println("생일 축하드립니다.");
				}
				System.out.println("주소 입력");
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
				String msg = String.format("\t\t\t...이하 %d명 가입\n\n", mem.size());
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
