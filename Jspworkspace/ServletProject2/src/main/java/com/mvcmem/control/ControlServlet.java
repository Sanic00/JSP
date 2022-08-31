package com.mvcmem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.action.Action;

/*@WebServlet("/ControlServlet") web.xml쓸꺼라서 안써도 됨*/
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//서비스에서 다 처리하기떄문에 요청과 응답을 다 처리해줌 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			//Action import 시키기 
			Action action = factory.getAction(cmd);
			
			//요청과 응답을 같이 넘겨준다
			ActionForward af = action.execute(request, response);
			if(af.isRedirect()) { //어디로 넘겨줄지 응답에 대한것
				response.sendRedirect(af.getUrl()); //url가져온다.
			}else {
			//RequestDispatcher 객체에서 제공하는 메소드를 이용하여 요청 재지정을 할 떄는 재지정하는 자원이 반드시
			//현재 자원과 동일한 웹 어플리케이션에 있어야만 합니다.
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				//포워드 방식으로
				rd.forward(request, response);
			}
			
		}else {
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			
			out.println("<h4>올바른 요청이 아닙니다!!!!</h4>");              
			out.println("<h4>http://localhost:9090/ServletProject2/mvcmem/member.mdo?cmd=요청키워드</h4>"); //형식을 잡아줌
			
			
			out.println("</body>");
			out.println("</html>");
			
		}
		
		
	}

}
