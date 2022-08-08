package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jdi.Value;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//어플리케이션 저장소
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		//쿠키는 배열로 오기때문에 배열로 설정
		Cookie[] cookies = request.getCookies();		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String v_ = request.getParameter("v"); //임시변수로 받음
		String op = request.getParameter("operator");
		
		//값을 입력하지 않을때 0으로 처리하기
		int v = 0;
	
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			
			//쿠키는 바로 읽히는게 아니고 반복문을 통해서 찾게됨
			int x = 0;
			for(Cookie c : cookies) 
			if(c.getName().equals("value")) {
				x = Integer.parseInt(c.getValue());
				break;
				}
			
				
			int y = v;
			
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			
			String operator = "";
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
					}
			
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
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
				
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
				
			//쿠키는 문자열로 저장해야됨
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			//모든페이지를 요청할때마다 valuecookie를 가져와라 
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(24*60*60); //만료시간 
			opCookie.setPath("/calc2");
			
			//클리이언트 한테 전달
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//사용자에게 다른 홈페이지로 전환 시킬수 있는 메소드
			response.sendRedirect("calc2.html");
			
		}
		
	}

}
