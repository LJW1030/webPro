package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Member;
@Mapper
public interface MemberDao {
	public int confirm(String mid);
	public int join(Member member);
	public Member memberDetail(String mid);
	public int modifyMember(Member member);
}
