package com.mvcmem.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvcmem.control.ActionForward;
import com.mvcmem.model.StudentDAO;
import com.mvcmem.model.StudentVO;



public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		//로그인이 된 상태에서 회원정보수정을 해야되니 세션
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		
		StudentDAO dao  = StudentDAO.getInstance();
		 //dao getmember메소드에 있는 매개변수로 가져ㅇ온다.
		
 
		StudentVO vo = new StudentVO(
		loginID,
		request.getParameter("pass"), 
		request.getParameter("name"), 
		request.getParameter("phone1"), 
		request.getParameter("phone2"), 
		request.getParameter("phone3"), 
		request.getParameter("email"), 
		request.getParameter("zipcode"), 
		request.getParameter("address1"), 
		request.getParameter("address2"),
		request.getParameter("address3"));
		
		dao.updateMember(vo);
		
		return new ActionForward("/mvcmem/modifyProc.jsp", false);
	}

}
