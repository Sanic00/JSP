package com.test.urlpattern;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//패턴 회원가입등에서 사용됨 


//@WebServlet("*.mdo")  //관공서들이  패턴 go 를 많이 씀 *. 어떤 패턴이 오던 다 됨 *.안녕하세요 등등
public class ETestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ETestServlet ...............");
	} 

}
