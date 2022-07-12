package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BContentService;
import service.BDeleteService;
import service.BListService;
import service.BModifySerivce;
import service.BModifyViewService;
import service.BReplyService;
import service.BReplyViewService;
import service.BWriteService;
import service.Service;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;
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
		if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/write_view.do")) { // 원글쓰기
			viewPage = "board/write_view.jsp";
			write_view = true;
		}else if(command.equals("/write.do")) { // 원글쓰기 DB 저장
			if(write_view) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.equals("/modify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage="board/modify_view.jsp";
		}else if(command.equals("/modify.do")) {
			service = new BModifySerivce();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
		}else if(command.equals("/reply.do")) {
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
