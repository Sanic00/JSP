package com.test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                   //경로를 지정해준다
		String readFile = "/WEB-INF/textFile.txt";
		
	    InputStream is = getServletContext().getResourceAsStream(readFile);
	    
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    
	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><body>");
		            //한줄씩 읽는 메서드 
		String str = reader.readLine();
		
		while(str != null) {
			out.println(str + "<br>");
			str = reader.readLine();
		}
		
		reader.close();
		
		out.println("</body></html>");
	}

}
