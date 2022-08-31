package com.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.control.ActionForward;

public class IndexAction implements Action {

	@Override //오버라이딩 되서 재정의 됨
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		System.out.println("IndexAction의 execute() 메소드가 수행됨");
		
		
		//액션 포워드 자바 파일에서 오버로딩된거를 리턴함
		return new ActionForward("index.jsp", false);
	}

}
