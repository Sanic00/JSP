package com.mvc.control;

import com.mvc.action.Action;
import com.mvc.action.IndexAction;

public class ActionFactory {

	//싱글톤으로 만들어라
	private static ActionFactory factory;
	
	private ActionFactory() {
		
	}
	
	public static synchronized  ActionFactory getInstance()  {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	
	
		//매개변수로 명령이 들어오면 
	public Action getAction(String cmd) { //파라미터값 날릴떄 ServletProject/mvc/test.do?cmd = index
		Action action = null;
		
		if(cmd.equals("index")) {
			action = new IndexAction();
		}
		return action;
	}
}
