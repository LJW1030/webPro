package com.lec.member;

public class MemberTestMain {

	public static void main(String[] args) {
		Member member = new Member("aaa","xxxxxx","홍길동","hong@company.com","서울 강남구","2000-01-01","남자\n");
		Member member2 = new Member("bbb","xxxxxx","김길동","dong@company.com","서울 강남구","1999-03-03","여자");
		Member[] mem = {member,member2};

		for(int idx=0; idx<mem.length; idx++) {
			System.out.println(mem[idx].infoString());
		}
		
	}

}
