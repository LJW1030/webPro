package com.lec.member;

public class MemberTestMain {

	public static void main(String[] args) {
		Member member = new Member("aaa","xxxxxx","ȫ�浿","hong@company.com","���� ������","2000-01-01","����\n");
		Member member2 = new Member("bbb","xxxxxx","��浿","dong@company.com","���� ������","1999-03-03","����");
		Member[] mem = {member,member2};

		for(int idx=0; idx<mem.length; idx++) {
			System.out.println(mem[idx].infoString());
		}
		
	}

}
