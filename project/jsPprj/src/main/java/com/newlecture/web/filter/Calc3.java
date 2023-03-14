package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
 * cookie 사용범위: 전역범위에서 사용하는 저장 공간
 * 		  생명주기: WAS가 시작해서 종료할 때 까지 
 * 		  저장위치: WAS 서버의 메모리 
 * 오랜기간 값을 저장하고 싶고 특정URL을 저장하고 싶으면 쿠키를 사용해라
 * session 은 오랜기간 저장이 되지않는다.
 * 캐시(Cache)란 무엇일까?

캐시는 쉽게 말해 리소스 파일의 임시 저장소라고 하는데 자주 사용하는 데이터나 값을 미리 복사해 놓는 임시 장소이다.
쿠키와 캐시 모두 정보를 저장하여 재활용하는 기술이지만, 쿠키는 사용자의 수고를 덜어주는 데 목적을 두고 캐시는 데이터의 전송량을 줄이고 서비스 이용 속도를 높이는 데 목적을 둡니다.
캐시에 미리 데이터를 복사해 놓으면 데이터에 빠르게 접근할 수 있다. 

 * */

	/**
	 *
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String v_= request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		//계산
		if(op.equals("=")) {
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
				 x = Integer.parseInt(c.getValue());
				 break;
				 
				}
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
		
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
		   response.getWriter().printf("result is %d\n", result);
}
		else {
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);

//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			//cookie는 문자열만 가능 
			Cookie valueCookie = new Cookie("value",String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			//cookie 경로 설정 다른곳으로 못가게 설정할수 있음 설정 경로에만 쿠기가 전달됨
			valueCookie.setPath("/calc2");
			//초단위로 설정가능 설정하면 브라우저가 닫혀도 컴퓨터 안에 쿠키에 저장되있음
			valueCookie.setMaxAge(24*60*60);
			
			opCookie.setPath("/calc2");
			opCookie.setMaxAge(60);
			
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//다른페이지로 전환
			response.sendRedirect("calc2.html");
			
		} 
		
	}
}