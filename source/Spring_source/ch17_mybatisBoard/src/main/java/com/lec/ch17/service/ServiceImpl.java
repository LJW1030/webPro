package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.board;
import com.lec.ch17.util.Paging;
@Service
public class ServiceImpl implements BService {
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<board> list(String pageNum) {
		Paging paging = new Paging(dao.totCnt(), pageNum, 10, 10);
		board dto = new board();
		dto.setStartRow(paging.getStartRow());
		dto.setEndRow(paging.getEndRow());
		return dao.list(dto);
	}

	@Override
	public int write(board dto, HttpServletRequest request) {
		return dao.write(dto);
	}

	@Override
	public int totCnt() {
		return dao.totCnt();
	}

	@Override
	public int hitup(int bid) {
		return dao.hitup(bid);
	}

	@Override
	public board content(int bid) {
		hitup(bid);
		return dao.content(bid);
	}

	@Override
	public int stepA(board dto) {
		return dao.stepA(dto);
	}

	@Override
	public int reply(board dto, HttpServletRequest request) {
		dto.setBip(request.getRemoteAddr());
		stepA(dto);
		return dao.reply(dto);
	}

	@Override
	public int update(board dto, HttpServletRequest request) {
		return dao.update(dto);
	}

	@Override
	public int delete(int bid) {
		return dao.delete(bid);
	}

}
