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

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
 * 어플리케이션 과 세션의 차이점
 * 어플리케이션 객체는 그 객체를 사용할때 어플리케이션 전역
 * 
 * 세션 객체는 세션 범주안에서만 사용가능 (현재접속)
 * 현재접속자마다 그 공간이 달라지는것이 세션
 */
	
	
	
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
			valueCookie.setPath("/Calc2");
			opCookie.setPath("/Calc2");
			
			//클리이언트 한테 전달
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
		}
		
	}

}
