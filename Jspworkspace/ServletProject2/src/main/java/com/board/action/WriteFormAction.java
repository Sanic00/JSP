package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num =0, ref = 1, step =0, depth = 0;
		try {
		
			if(request.getParameter("num")!= null){
				//getParameter는 String 타입이라 정수형으로 형변환 해서 저장
				num = Integer.parseInt(request.getParameter("num"));
				ref	= Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
			}catch(Exception e) {}
		
			request.setAttribute("num", num);
			request.setAttribute("ref", ref);
			request.setAttribute("step", step);
			request.setAttribute("depth", depth);
				
			return "/board/writeForm.jsp";
			
}
}