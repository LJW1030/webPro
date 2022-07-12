package com.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SameNameP
 */
@WebServlet("/ex1")
public class SameNameP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SameNameP() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String menu[] = request.getParameterValues("menu");
	String rest[] = request.getParameterValues("rest");
	String nation = request.getParameter("nation");
	
	response.setContentType("text/html; charset= utf-8");
	PrintWriter out = response.getWriter();
	if(menu!=null) {
		out.println("<h4>선택하신 메뉴는 ");
		for(String m : menu) {
			out.print(m+", ");
		}out.println("입니다</h4>");
	}else {
			out.println("<h4>메뉴를 선택해주세요</h4>");
		}
	if(rest!=null) {
		out.println("<h4>선택하신 식당의 지역은 ");
		for(String r : rest) {
			out.print(r+", ");
		}out.println("입니다</h4>");
	}else {
			out.println("<h4>식당지역을 선택해주세요</h4>");
		}
	out.println("<h4>선택하신 음식타입은 "+nation+" 입니다.</h4>");
	out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
