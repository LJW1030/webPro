package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.dto.board;
import com.lec.ch17.service.BService;
import com.lec.ch17.util.Paging;

@Controller
public class BController {
	@Autowired
	private BService service;
	@RequestMapping(value="list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("list", service.list(pageNum));
		model.addAttribute("paging", new Paging(service.totCnt(), pageNum, 10, 10));
		return "list";
	}
	@RequestMapping(value="writeView", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		return "write";
	}
	@RequestMapping(value="write", method =RequestMethod.POST)
	public String write(board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("writeResult", service.write(board, request));
		return "forward:list.do";
	}
	@RequestMapping(value="content", method = {RequestMethod.GET, RequestMethod.POST})
	public String contentView(int bid, Model model) {
		model.addAttribute("board", service.content(bid));
		return "content";
	}
	@RequestMapping(value="updateView", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int bid, Model model) {
		model.addAttribute("board", service.content(bid));
		return "modify";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(board board, HttpServletRequest request, Model model) {
		try {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("updateResult", service.update(board, request));
		}catch(Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다. 수정 실패");
			return "forward:updateView.do";
		}
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", service.delete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value="replyView", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", service.content(bid));
		return "reply";
	}
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String reply(board board, HttpServletRequest request, Model model) {
		model.addAttribute("board", service.reply(board, request));
		return "forward:list.do";
	}
	
}
