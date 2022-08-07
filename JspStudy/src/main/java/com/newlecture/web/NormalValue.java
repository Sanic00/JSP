package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hii")
public class NormalValue extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
			
		//임시로 담아두기
		 String cnt_ = request.getParameter("cnt");
		
		int cnt = 100;
		if(cnt_ != null && !cnt_.equals("")) 
			cnt = Integer.parseInt(cnt_);
		
		//클라이언트가 쿼리스트링 값을 문서형식으로 요청함
		//파라미터 안에 count=cnt 라는 값을  받아서 카운트 값만큼 반복한다.
		for(int i=0; i<cnt; i++)
			out.println((i+1)+"안녕 Servlet!!<br>");
		
		/*
		 * http://.../hello?cnt = 3 은 "3"으로 오고
		 * http://.../hello?cnt =  은 ""으로 오고
		 *  http://.../hello?  은 null값으로 오고
		 *   http://.../hello  은 null값으로 오고
		 */
		
}
}