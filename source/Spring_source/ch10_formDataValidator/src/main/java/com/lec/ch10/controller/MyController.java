package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {
	@RequestMapping(value="inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "ex1/inputForm";
	}
	@RequestMapping(value="/input.do", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		// 검증객체를 이용해서 검증 method 호출
		StudentValidator validator = new StudentValidator();;
		validator.validate(student, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수");
			}
			return "ex1/inputForm";
		}
		/* if(에러 잡음){
			viewPage = "inputForm.do";
			에러난곳 점검메시지 model에 add
			viewPage ="ex1/inputResult";
		}*/
		return "ex1/inputResult";
	}
}
