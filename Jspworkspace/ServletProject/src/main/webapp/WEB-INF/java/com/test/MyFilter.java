package com.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;



@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter 제거");

	}

	@Override																	//chain은 요청 응답이 계속이루어진다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter 요청 필터 코드 작업.......");
		
		//한글 처리 작업
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		System.out.println("MyFilter 요청 필터 코드 작업.......");

	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		System.out.println("MyFilter 초기화........");
	}

}
