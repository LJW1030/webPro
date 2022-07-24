package com.ex.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.ch15.service.EmpService;
import com.ex.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService eService;
	
	@RequestMapping(value="empList", method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		model.addAttribute("empList", eService.empList(pageNum));
		model.addAttribute("paging", new Paging(eService.totCnt(), pageNum, 10, 5));
		return "empList";
	}
}
