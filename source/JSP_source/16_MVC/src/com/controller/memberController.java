package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberJoinService;
import com.service.MemberListService;
import com.service.Service;

/**
 * Servlet implementation class memberController
 */
@WebServlet("*.do")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/memberList.do")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		}
		if(command.equals("/memberJoin_view.do")) {
			viewPage = "member/join.jsp";
		}
		if(command.equals("/memberJoin.do")) {
			service = new MemberJoinService();
			service.execute(request, response);
			viewPage = "memberList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
