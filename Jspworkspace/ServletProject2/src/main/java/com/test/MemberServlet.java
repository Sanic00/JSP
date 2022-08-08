package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*; //여기안에 Enueration이 있음.
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get방식일떄 post를 호출
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
	
		//값이 여러개 일 때는 Enueration을 사용 Stirng타입으로 반환됨
		 Enumeration<String> enu = request.getParameterNames();
		 
		 //인코딩에 대한 내용을 전송할때 
		 response.setContentType("text/html; charset = UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 out.println("<html><body>");
		 //값이 다르다면 출력한다
		 while(enu.hasMoreElements()) {
			 String name = enu.nextElement();
//			 값을 가져올때는 파라미터
			 String value = request.getParameter(name);
			 out.println(name + ":" + value + "<br>");
		 }

		 out.println("</body></html>");
		
		
	
	}

}
