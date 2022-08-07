package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8"); // 내가 UTF-8 인코딩형태로 보낼테니 
		response.setContentType("text/html; charset=UTF-8;"); // 넌 UTF-8로 읽어라 
		
		PrintWriter out = response.getWriter();
		
		for(int i =0; i<100; i++) {
			out.println((i+1) + "안녕 Hello Servlet!!!");
		}
	}
	
	
}
