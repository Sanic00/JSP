package com.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;

import com.board.action.CommandAction;


public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 명령어와 명령어 처리 클래스를 쌍으로 불러다가 저장함
	private Map<String, Object> commandMap =  new HashedMap<String, Object>();
	
	//명령어와 처리 클래스가 매핑되어 있는 Command.properties 파일을 읽어와서 
	// Map객체인 commandMap에 저장한다.
			
		
	
	public void init(ServletConfig config) throws ServletException {
	
		//web.xml 파일에서 propertyConfig에 해당하는 init-param의 값을 읽어와야된다.
		String props = config.getInitParameter("propertyConfig"); 
		
		//명령어 와 처리클래스의 매핑정보를 저장할 Properties 객체를 생성함
		Properties pr = new Properties();
		
		String path = config.getServletContext().getRealPath("/WEB-INF");
		
		//파일이라서 파일입출력이 필요함
		FileInputStream f = null;
		
		try {
			//Command.properties 파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			//Command.properties 파일의 정보를 Properties 객체에 저장한다.
			pr.load(f);
			
		}catch(Exception e) {
			throw new ServletException(e);			
		}finally {
			if(f != null) try {f.close();}catch(IOException ex) {}
		}
		//Iterator 객체를 이용해서 파일 내용을 키값을 읽어옴
		//Iterator 객체 생성한다  //중복을 허용하지 않음
		Iterator<Object> keyIter = pr.keySet().iterator();
		//Command만 꺼내옴
		while (keyIter.hasNext()) {
			
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);//딸려있는 키값으로 불러온다? 
			
			try {
				Class commandClass = Class.forName(className);
				// 해당 클래스의 객체를 생성함
				Object commandInstance = commandClass.newInstance();
				
				//Map 객체인 commandMap 에 객체를 저장함
				commandMap.put(command, commandInstance);
				
			}catch(ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
		
	}
	//사용자의 요청을 분석해서 해당 작업을 처리하는 메소드
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) { //경로가 없을때?
				command = command.substring(request.getContextPath().length());
			}
			//맵에서 꺼내옴 형변환도 시켜줘야된단다.
			com = (CommandAction)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		//포워드 방식으로
		rd.forward(request, response);
		
	}


}
