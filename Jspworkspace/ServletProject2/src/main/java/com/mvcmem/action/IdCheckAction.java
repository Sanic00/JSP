package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.control.ActionForward;
import com.mvcmem.model.StudentDAO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//idcheck는 DB랑 연결이 되어있다. idCheck.jsp에 있는 자바 코드를 여기로 옮긴다.
		
		//DAO객체를 만들어 준다.   getInstance로 db연결 시켜준다.  
		StudentDAO dao = StudentDAO.getInstance();
		
		String id = request.getParameter("id");
		boolean check = dao.idCheck(id);
		//속성값 저장시킴
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		
		return new ActionForward("/mvcmem/idCheck.jsp", false);
	}

}
