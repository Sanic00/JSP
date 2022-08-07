package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie_App_SE")
public class Cookie_App_SE extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	
	/*
	 * 내가 만약 3이라는카운트를 저장할려고 한다 1년정도 
	 * 기간이 길다면 무조건 Cookie를 써라 
	 * 식별 ID = Cookie  
	 * 
	 * 특정 url에서 데이터를 쓰는거면 Cookie를 써야한다.
	 * 
	 * Cookie 
	 * 사용범위 : web Browser 별 지정한 path(url) 범주 공간
	 * 생명주기 : Browser에 전달한 시간부터 만료시간까지
	 * 저장위치 : Web Browser의 메모리 또는 파일
	 * 
	 * Application
	 * 사용범위 : 전역 범위에서 사용하는 저장공간
	 * 생명주기 : WAS(web application server)가 시작해서 종료 할 때 까지
	 * 저장위치 : WAS 서버의 메모리
	 * 
	 * Session
	 * 사용범위 : 세션 범위에서 사용하는 저장 공간 
	 * 생명주기 : 세션이 시작해서 종료 할 때 까지
	 * 저장위치 : WAS 서버의 메모리
	 * 
	 */
	
	
    public Cookie_App_SE() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
