package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	public int confirm(String mid);
	public int join(Member member, HttpSession sesssion);
	public String loginCheck(String mid, String mpw, HttpSession session);
	public Member memberDetail(String mid);
	public int modifyMember(Member member);
}
