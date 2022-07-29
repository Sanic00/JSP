package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		String [] sports = request.getParameterValues("sports");
		String gender = request.getParameter("gender");
		
		//확인차 한것
//		for(String sport : sports) {
//			System.out.println("취미 :" + sport + ", ");																																																																																																																																																																																																																																																																																																		
//		}
//		System.out.println();
//		System.out.println("성별 :" + gender);
		
		 response.setContentType("text/html; charset = UTF-8");
		 
		 PrintWriter  out = response.getWriter();
		 
		 out.println("<html>");
		 out.println("<body>");
		 
		 for(String sport : sports) {
				System.out.println("취미 :" + sport + ", ");																																																																																																																																																																																																																																																																																																		
			}
		 System.out.println("성별 :" + gender);
		 
		 out.println("</body>");
		 out.println("</html>");
		 
		
	}

}
