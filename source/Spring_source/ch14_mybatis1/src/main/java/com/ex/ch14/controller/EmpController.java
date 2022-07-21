package com.ex.ch14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.ch14.Service.EmpService;
import com.ex.ch14.dto.Emp;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(@ModelAttribute("schEmp") Emp schEmp, Model model) {
		model.addAttribute("empList", empService.empList(schEmp));
		model.addAttribute("deptList", empService.deptList());
		return "emp";
	}
}
