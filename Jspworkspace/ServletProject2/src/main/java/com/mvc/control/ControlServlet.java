package com.mvc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//우리가 만든 Action이 import 되어야됨
import com.mvc.action.Action;

//이게 요청 파라미터를 명령어로 전달하는 방법에 의한 Model2 방식 구현 첫번째 방법임

/*@WebServlet("/ControlServlet")  xml안에 있는애랑 충돌 되면 안된다.*/
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//여기가 사용자의 요청 분석 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//먼저 인코딩 먼저
		request.setCharacterEncoding("utf-8");
		//파라미터값 가져오기
		String cmd = request.getParameter("cmd");
		
		//cmd 명령이 있을때 파라미터값이 있을때
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			//Action import 시키기 
			Action action = factory.getAction(cmd);
			
			//요청과 응답을 같이 넘겨준다
			ActionForward af = action.execute(request, response);
			if(af.isRedirect()) { //어디로 넘겨줄지 응답에 대한것
				response.sendRedirect(af.getUrl()); //url가져온다.
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				//포워드 방식으로
				rd.forward(request, response);
			}
		
		//cmd 명령이 없을때
		}else {
			response.setContentType("text/html; charset=utf-8");
			//출력 객체 생성 
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			
			out.println("<h4>올바른 요청이 아닙니다!!!!</h4>");
			out.println("<h4>http://localhost:9090/ServletProject2/mvc/test.do?cmd=요청키워드</h4>"); //형식을 잡아줌
			
			
			out.println("</body>");
			out.println("</html>");
			
		}
		
		
	}

}
