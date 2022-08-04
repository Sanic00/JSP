package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		

	}
	
	// 필터는 클라이언트와 컨테이너 사이???
	//요청 응답을 굳이 추가 할 필요 없이 필터라는 놈을 이용해가지고 utf-8 설정가능
	// 필터가 서블렛을 실행할지 말지를 결정할 수가 있다.
	@Override 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response); // 요청이 오면 흐름을 넘겨서 다음 필터 서블릿을 실행하게 한다.
		System.out.println("hello filter"); //요청이 될때마다 얘가 계속 출력됨 확인차 위해 쓴거임
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	

	}

}
