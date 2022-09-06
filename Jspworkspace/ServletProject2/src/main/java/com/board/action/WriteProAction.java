package com.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardVO;

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		//데이타 빈 처리
		BoardVO article = new BoardVO(); 
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPass(request.getParameter("pass"));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setStep(Integer.parseInt(request.getParameter("step")));
		article.setDepth(Integer.parseInt(request.getParameter("depth")));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		
		
		
		
		//db연결 
		BoardDAO dbPro = BoardDAO.getInstance();
		dbPro.insertArticle(article);
		return "/board/writeProc.jsp";
	}

}
