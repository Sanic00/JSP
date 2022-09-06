package com.board.action;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
//글목록을 처리하는 클래스
import com.board.model.BoardVO;
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		//한 페이지에  보여줄 글 목록 수 지정
	    int pageSize = 5;
	    
	    String pageNum = request.getParameter("pageNum");
	 
	    if(pageNum == null){
	    	pageNum = "1";
	    }
	    //현재 페이지 
	    int currentPage =Integer.parseInt(pageNum);
	    
	    int startRow = (currentPage-1) * pageSize + 1; 
	    int endRow = currentPage* pageSize;
	   
	    int count = 0;
	   	int number = 0;
	   	List<BoardVO> articleList = null;
	   	BoardDAO dbPro = BoardDAO.getInstance(); // db연결
	   	
	   	count = dbPro.getArticleCount(); // 전체의 글을 불러오도록
	   	
	   	 if(count > 0){ 
	 		//하나라도 존재 하면 리스트를 출력해라
	 		articleList = dbPro.getArticles(startRow, endRow);
	 	
	   	 
	   	 } else { // 검색 일 경우
			articleList = Collections.emptyList();
		}
		//글 목록의 표시할 글 번호
	 	number = count - (currentPage -1) * pageSize;
	    
	 									//String타입을 정수형으로 바꾼다
	 	request.setAttribute("currentPage", new Integer(currentPage));
	 	request.setAttribute("startRow", new Integer(startRow));
	 	request.setAttribute("endRow", new Integer(endRow));
	 	//총 몇개인지
	 	request.setAttribute("count", new Integer(count));
	 	request.setAttribute("pageSize", new Integer(pageSize));
	 	request.setAttribute("number", new Integer(number));
	 	request.setAttribute("articleList", articleList);
	 	
	 	
	 	//해당 뷰로 반환해줌
		return "/board/list.jsp";
	}

}
