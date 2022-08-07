package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String x_ = request.getParameter("x"); //임시변수로 받음
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");
		
		//밑에 두 변수는 빈문자열이 못오도록 0으로 초기화
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		int result = 0;
		//버튼이 두개 이상 있을 경우에
		//오퍼레이터가 덧셈을 눌렀을때 덧셈을 하게 
		if(op.equals("덧셈"))
			result = x + y;

		else {
			result = x - y;
		}
	
		
		response.getWriter().printf("reuslt is %d\n", result);
	}

}
