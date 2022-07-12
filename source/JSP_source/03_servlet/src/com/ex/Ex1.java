package com.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/gugudan")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] num = request.getParameterValues("num");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		for(int i=0; i<=num.length; i++) {
			int su = Integer.parseInt(num[i]);
			out.println(su+"단");
			out.println("<hr>");
			for(int j=1; j<=9; j++) {
				out.println(su+" * "+j+" = "+su*j+"<br>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
