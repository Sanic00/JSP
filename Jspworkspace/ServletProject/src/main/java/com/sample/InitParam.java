package com.sample;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/InitParam")
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String company;
	private String manager;
	private String tel;
	private String email;
	
	
	
	public void init() throws ServletException {
		System.out.println("초기화 메소드 수행 됨 ");
		/*
		 * ServletContext란?
		 * ServletContext 객체는 web application 당 하나씩 생성되는 객체이다.
		 * web application 전체에서 참조 할 수 있는 초기 파라미터 값을 저장(전역변수와 같음)
		 * Servlet에서는 getServletContext()를 이용해서 ServletContext 객체를 가져 올 수 있다.
		 * 
		 */
		
		//ServletContext의 초기 파라미터 값 읽기
		
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");
		
		
		//ServletConfig의 초기 파라미터 값 읽기
		
		
		/*
		 * ServletConfig
		 * ServletConfig 객체는 Container 가 서블릿을 생성할때 생성되는 객체이다.
		 * 
		 * DD(web.xml 의약자)를 읽어서 이름/값을 쌍으로 된 초기화 파라미터를 읽어서 저장함
		 * ServletConfig 객체는 Servlet 객체당 한개씩 생성함
		 * Servlet 에서 getServletConfig()를 이용해서 Servlet과 관련된  ServletConfig 객체를 얻을 수 있음
		 * 
		 */
		
		//파라미터값을 초기값으로 
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문서 HTML이 인코딩이 뭔지 알려주기 위해서 항상 써야된다 서블릿을 사용할때는
		request.setCharacterEncoding("UTF-8");
		
		
	}

}
