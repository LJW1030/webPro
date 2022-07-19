package com.ex.ch13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ex.ch13.service.FileService;

public class FileController {
	@Autowired
	private FileService fservice;
	@RequestMapping(value="fileInput", method = RequestMethod.GET)
	public String fileInput() {
		return "fileInput";
	}
	@RequestMapping(value="fileupload", method = RequestMethod.POST)
	public ModelAndView fileupload(MultipartHttpServletRequest mRequest,
								ModelAndView mav) {
		if(fservice.fileUp(mRequest, mav)) {
			mav.addObject("fileResult", "파일 업로드 성공");
		}else {
			mav.addObject("fileResult", "파일 업로드 실패");
		}
		mav.setViewName("fileResult");
		return mav;
	}
}
