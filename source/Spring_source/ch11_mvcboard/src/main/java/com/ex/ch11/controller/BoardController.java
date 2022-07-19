package com.ex.ch11.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.ch11.service.BListService;
import com.ex.ch11.service.Service;

@Controller
@RequestMapping("mvcboard") // 공통요청경로
public class BoardController {
	private Service service;
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
}
