package com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> members = mDao.listMember();
		request.setAttribute("memberList", members);
	}

}
