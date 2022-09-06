package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
	    String pageNum = request.getParameter("pageNum");
	    String pass = request.getParameter("pass");
	   
	    //pass deleteform 패스에 가져온다.
	    BoardDAO dbPro = BoardDAO.getInstance();
	   
	    	
	    int check = dbPro.deleteArticle(num, pass);
	    
	    request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
	    

	    
		
		
		
		return "/board/deleteProc.jsp";
	}

}
