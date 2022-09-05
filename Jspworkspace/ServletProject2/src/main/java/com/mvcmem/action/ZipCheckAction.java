package com.mvcmem.action;

import java.io.IOException; 
import java.util.*; //벡터 추가
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.model.StudentDAO; //zipcheck import 되어있던 것들 
import com.mvcmem.model.ZipCodeVO;

import com.mvcmem.control.ActionForward;

public class ZipCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
				request.setCharacterEncoding("UTF-8");
	    	
				StudentDAO dao = StudentDAO.getInstance();
				
		   //자바스크립트에서 2개의 파라미터가 넘어와야된다. 스크립트가 y(yes) 일때 검색이 된다.
		     String check = request.getParameter("check");
		     String dong = request.getParameter("dong"); //검색을 동으로 한다.
		    
		     // 파라미터 값을 zipcodeRead() 메소드의 매개변수로 전달
		       Vector<ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);
		      
		       int totalList = zipcodeList.size();
//		       System.out.println("검색 개수"+ totalList);
		
		       
		       request.setAttribute("check", check);
		       request.setAttribute("dong", dong);
		       request.setAttribute("zipcodeList", zipcodeList);
		       request.setAttribute("totalList", totalList);
	
		return new ActionForward("/mvcmem/zipCheck.jsp", false);
	}

}
