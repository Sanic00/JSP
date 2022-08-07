package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String num1 = request.getParameter("x");
		String num2 = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(!num1.equals(""))
			x = Integer.parseInt(num1);
		
		if(!num2.equals(""))
			y = Integer.parseInt(num2);
		
		int sum = x+y;
		int minus = x - y;
		response.getWriter().print("두 수의 합은"+ sum +"입니다.");
		response.getWriter().print("두 수의 뺄셈은"+ minus +"입니다.");
		
		
	}

}
