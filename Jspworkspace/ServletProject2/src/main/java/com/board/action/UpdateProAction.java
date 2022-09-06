package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		//페이지 넘버를 가져온다
		String pageNum = request.getParameter("pageNum");
				
		
		//데이타 빈 처리
		BoardVO article = new BoardVO(); 
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPass(request.getParameter("pass"));
		
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/board/updateProc.jsp";
	}

}
