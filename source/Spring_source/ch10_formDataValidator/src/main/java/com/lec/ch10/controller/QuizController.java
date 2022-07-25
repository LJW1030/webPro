package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;

@Controller
public class QuizController {
	@ModelAttribute("cnt")
	public String cnt() {
		return "현재 총 4명";
	}
	@RequestMapping(value="quizInput.do", method=RequestMethod.GET)
	public String quizInput() {
		return "quiz/quizInput";
	}
	@RequestMapping(value="result.do", method=RequestMethod.POST)
	public String quizResult(Quiz quiz, Errors errors, Model model) {
		QuizValidator validator = new QuizValidator();
		validator.validate(quiz, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "이름이 올바르지 않습니다");
			}
			if(errors.getFieldError("kor") != null || ("eng") != null || ("mat") != null) {
				model.addAttribute("scoreError", "점수가 올바르지 않습니다");
			}
			
			return "quiz/quizInput";
		}
		return "quiz/quizResult";
	}
	
}
