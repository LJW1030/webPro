package com.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/style.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table><tr><th colspan='2'>반갑습니다 "+name+"님</th></tr>");
		out.println("<tr><th>글제목</th><td>"+title+"</td></tr>");
		out.println("<tr><th>글내용</td><th><pre>"+content+"</pre></td></tr>");
		out.println("</table></body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
