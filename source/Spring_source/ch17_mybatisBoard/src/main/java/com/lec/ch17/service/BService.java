package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.dto.board;

public interface BService {
	public List<board> list(String pageNum);
	public int write(board dto, HttpServletRequest reqeust);
	public int totCnt();
	public int hitup(int bid);
	public board content(int bid);
	public int stepA(board dto);
	public int reply(board dto, HttpServletRequest request);
	public int update(board dto, HttpServletRequest request);
	public int delete(int bid);
}
