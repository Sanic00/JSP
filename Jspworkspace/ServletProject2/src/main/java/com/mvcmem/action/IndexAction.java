package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.control.ActionForward;


//.XXXAction : Action 인터페이스의 메소드를 재정의 하고 있는 클래스 
//				실질적인 비즈니스 로직의 구현체이다.
public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		
		return new ActionForward("/mvcmem/index.jsp", false); //포워드라는 객체를 반환시킴
	}

}
