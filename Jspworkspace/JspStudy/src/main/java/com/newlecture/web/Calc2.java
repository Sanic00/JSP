package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//어플리케이션 저장소
		ServletContext application = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String v_ = request.getParameter("v"); //임시변수로 받음
		String op = request.getParameter("operator");
		
		//값을 입력하지 않을때 0으로 처리하기
		int v = 0;
	
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String operator = (String)application.getAttribute("op");
			
			int result = 0;
			//버튼이 두개 이상 있을 경우에
			//오퍼레이터가 덧셈을 눌렀을때 덧셈을 하게 
		
			if(operator.equals("+"))
				result = x + y;

			else 
				result = x - y;
			
			//결과 출력
			response.getWriter().printf("reuslt is %d\n", result);
			}
		
			//값을저장
			else {
			//자바에 있는 map 컬렉션처럼 동일하다.
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}
		
	}

}
