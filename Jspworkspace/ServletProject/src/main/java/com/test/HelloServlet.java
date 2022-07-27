package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 여러개의  url을 사용할때
@WebServlet(name = "MyServlet", urlPatterns = { "/aa", "/bb" ,"/xxx"}) // <-- 여기가 요청하는 URL이다. 어노테이션을 이용하는 방법:(맵핑명)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override //init메소드는 호출할때 처음 실행할때 딱 한번만 호출 
	public void init() throws ServletException {
		System.out.println("init 요청");
	}
	
	
	
	
	// 얘가 요청한것들을 처리하는 놈들임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet 요청");
	
	}
	
	@Override //종료 할때 쓰는 메서드
	public void destroy() {
		System.out.println("destroy 요청");
	}
}
