package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

		//경로를 잡아줘야됨 어노테이션 기능을 쓸때는
@WebServlet("/login/Login") //어노테이션 기능을 활용한다 이것말고 xml로 사용할수있다 2가지 방법 존재
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//html의 파라미터 값을 받을 수 있도록 설정
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
	//	확인용
//		System.out.println("아이디 :"  + userid + ", 비밀번호 :" + passwd);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<body>");
			out.println("아이디 :" + userid + "<br>");
			out.println("비밀번호 :" + passwd + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
