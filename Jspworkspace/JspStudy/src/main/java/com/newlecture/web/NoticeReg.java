package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //한글은 2바이트임 근데  리퀘스트인코딩을 utf을 설정하지않으면 1byte씩 처리되서 깨져버림
		
		
		PrintWriter out = response.getWriter();
			//여기를 데이터베이스나 입출력으로 할수 있음
		 String title = request.getParameter("title");
		 String content = request.getParameter("content");
		
		 out.println(title);
		 out.println(content);
	
		
}
}