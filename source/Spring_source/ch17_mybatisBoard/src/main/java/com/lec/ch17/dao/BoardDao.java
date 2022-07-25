package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.board;

@Mapper
public interface BoardDao {
	public List<board> list(board dto);
	public int write(board dto);
	public int totCnt();
	public int hitup(int bid);
	public board content(int bid);
	public int stepA(board dto);
	public int reply(board dto);
	public int update(board dto);
	public int delete(int bid);
}
